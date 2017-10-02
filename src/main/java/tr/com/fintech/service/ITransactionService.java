package tr.com.fintech.service;

import tr.com.fintech.common.*;
import tr.com.fintech.common.dto.TransactionGetResponse;
import tr.com.fintech.common.dto.TransactionReportResponse;
import tr.com.fintech.common.dto.TransactionsListResponse;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public interface ITransactionService {

    /**
     * @param fromDate
     * @param toDate
     * @param merchantId
     * @param acquirerId
     */
    TransactionReportResponse getTransactionReport(LocalDate fromDate,
                                                   LocalDate toDate,
                                                   Long merchantId,
                                                   Long acquirerId);

    /**
     * @param fromDate
     * @param toDate
     * @param merchantId
     * @param acquirerId
     * @param errorCodeType
     * @param filterFieldType
     * @param operationType
     * @param paymentMethodType
     * @param statusType
     * @param filterValue
     * @param page              @return
     */
    TransactionsListResponse getTransactions(LocalDate fromDate,
                                             LocalDate toDate,
                                             Long merchantId,
                                             Long acquirerId,
                                             ErrorCodeType errorCodeType,
                                             FilterFieldType filterFieldType,
                                             OperationType operationType,
                                             PaymentMethodType paymentMethodType,
                                             StatusType statusType,
                                             String filterValue,
                                             Integer page);

    /**
     * @param transactionId
     * @return
     */
    TransactionGetResponse getTransaction(String transactionId);
}
