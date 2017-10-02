package tr.com.fintech.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tr.com.fintech.common.*;
import tr.com.fintech.common.dto.TransactionGetResponse;
import tr.com.fintech.common.dto.TransactionReportResponse;
import tr.com.fintech.common.dto.TransactionsListResponse;
import tr.com.fintech.controller.TransactionController;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionController.class);

    @Value("${fintech.transaction.report.url}")
    private String TRANSACTION_REPORT_URL;

    @Value("${fintech.transaction.query.url}")
    private String TRANSACTIONS_QUERY_URL;


    @Value("${fintech.transaction.get.url}")
    private String TRANSACTION_GET_URL;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JWTSecurityUtils jwtSecurityUtils;


    @Override
    public TransactionReportResponse getTransactionReport(@NotNull LocalDate fromDate,
                                                          @NotNull LocalDate toDate,
                                                          Long merchantId,
                                                          Long acquirerId) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Transaction reports is being requested : {} - {} - {} - {}", fromDate, toDate, merchantId, acquirerId);
        }

        Map<String, Object> params = new HashMap<>();
        addDateRangeParams(params, fromDate, toDate);

        Optional
                .ofNullable(merchantId)
                .ifPresent(aLong -> params.put(SecurityUtils.MERCHANT_PARAM_NAME, aLong));

        Optional.ofNullable(acquirerId)
                .ifPresent(aLong -> params.put(SecurityUtils.ACQUIRER_PARAM_NAME, aLong));


        return Optional
                .ofNullable(restTemplate.postForEntity(TRANSACTION_REPORT_URL, params, TransactionReportResponse.class))
                .map(response -> response.getBody())
                .orElse(null);
    }


    @Override
    public TransactionsListResponse getTransactions(LocalDate fromDate,
                                                    LocalDate toDate,
                                                    Long merchantId,
                                                    Long acquirerId,
                                                    ErrorCodeType errorCodeType,
                                                    FilterFieldType filterFieldType,
                                                    OperationType operationType,
                                                    PaymentMethodType paymentMethodType,
                                                    StatusType statusType,
                                                    String filterValue,
                                                    Integer page) {

        Map<String, Object> params = new HashMap<>();
        addDateRangeParams(params, fromDate, toDate);


        Optional
                .ofNullable(merchantId)
                .ifPresent(aLong -> params.put(SecurityUtils.MERCHANT_ID_PARAM_NAME, aLong));

        Optional.ofNullable(acquirerId)
                .ifPresent(aLong -> params.put(SecurityUtils.ACQUIRER_ID_PARAM_NAME, aLong));

        Optional.ofNullable(errorCodeType)
                .ifPresent(errorCodeType1 -> params.put(SecurityUtils.ERRORCODE_PARAM_NAME, errorCodeType1.getDescription()));


        Optional.ofNullable(filterFieldType)
                .ifPresent(filterFieldType1 -> params.put(SecurityUtils.FILTER_FIELD_PARAM_NAME, filterFieldType1.getDescription()));

        Optional.ofNullable(operationType)
                .ifPresent(operationType1 -> params.put(SecurityUtils.OPERATION_PARAM_NAME, operationType1.getName()));

        Optional.ofNullable(paymentMethodType)
                .ifPresent(paymentMethodType1 -> params.put(SecurityUtils.PAYMENTMETHOD_PARAM_NAME, paymentMethodType1.name()));

        Optional.ofNullable(statusType)
                .ifPresent(statusType1 -> params.put(SecurityUtils.STATUS_PARAM_NAME, statusType1.name()));


        Optional.ofNullable(filterValue)
                .ifPresent(filterVal -> params.put(SecurityUtils.FILTERVALUE_PARAM_NAME, filterVal));

        Optional.ofNullable(page)
                .ifPresent(pageVl -> params.put(SecurityUtils.FILTERVALUE_PARAM_NAME, pageVl));


        return Optional.ofNullable(restTemplate.postForEntity(TRANSACTIONS_QUERY_URL, params, TransactionsListResponse.class))
                .map(responseEntity -> responseEntity.getBody())
                .orElse(null);
    }

    @Override
    public TransactionGetResponse getTransaction(@NotNull String transactionId) {

        Map<String, Object> params = new HashMap<>();
        params.put(SecurityUtils.TRANSACTION_ID_PARAM_NAME, transactionId);


        return Optional.ofNullable(restTemplate.postForEntity(TRANSACTION_GET_URL, params, TransactionGetResponse.class))
                .map(responseEntity -> responseEntity.getBody())
                .orElse(null);
    }

    /**
     * helper method for building request params
     *
     * @param map
     * @param fromDate
     * @param toDate
     */
    private void addDateRangeParams(@NotNull Map map,
                                    LocalDate fromDate,
                                    LocalDate toDate) {

        Optional.ofNullable(fromDate)
                .ifPresent(localDate -> map.put(SecurityUtils.FROM_DATE_PARAM_NAME, localDate.toString()));

        Optional.ofNullable(toDate)
                .ifPresent(localDate -> map.put(SecurityUtils.TO_DATE_PARAM_NAME, localDate.toString()));
    }

}
