package tr.com.fintech.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.fintech.common.*;
import tr.com.fintech.common.dto.TransactionGetResponse;
import tr.com.fintech.common.dto.TransactionsListResponse;
import tr.com.fintech.service.ITransactionService;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3")
public class TransactionController {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private ITransactionService transactionService;



    @GetMapping(value = "/transactions/report",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTransactionReport(@RequestParam(name = "fromDate") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate fromDate,
                                               @RequestParam(name = "toDate") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate toDate,
                                               @RequestParam(name = "merchant", required = false) Long merchant,
                                               @RequestParam(name = "acquirer", required = false) Long acquirer) {

        return Optional.ofNullable(transactionService.getTransactionReport(fromDate, toDate, merchant, acquirer))
                .map(transActionReportResponse -> new ResponseEntity(transActionReportResponse, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.OK));
    }


    @GetMapping(value = "/transactions/query",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionsListResponse> getTransactions(@RequestParam(name = "fromDate", required = false) @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate fromDate,
                                                                    @RequestParam(name = "toDate", required = false) @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate toDate,
                                                                    @RequestParam(name = "merchantId", required = false) Long merchantId,
                                                                    @RequestParam(name = "acquirerId", required = false) Long acquirerId,
                                                                    @RequestParam(name = "errorCode", required = false) ErrorCodeType errorCodeType,
                                                                    @RequestParam(name = "filterField", required = false) FilterFieldType filterFieldType,
                                                                    @RequestParam(name = "operation", required = false) OperationType operationType,
                                                                    @RequestParam(name = "paymentMethod", required = false) PaymentMethodType paymentMethodType,
                                                                    @RequestParam(name = "status", required = false) StatusType statusType,
                                                                    @RequestParam(name = "filterValue", required = false) String filterValue,
                                                                    @RequestParam(name = "page", required = false) Integer page) {

        return Optional.ofNullable(transactionService.getTransactions(fromDate, toDate
                , merchantId, acquirerId, errorCodeType, filterFieldType, operationType, paymentMethodType, statusType, filterValue, page))
                .map(transactionsListResponse -> new ResponseEntity<>(transactionsListResponse, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.OK));
    }


    @GetMapping(value = "/transaction/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionGetResponse> getTransaction(@PathVariable(name = "id") String id) {

        return Optional.ofNullable(transactionService.getTransaction(id))
                .map(transactionGetResponse -> new ResponseEntity<>(transactionGetResponse, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.OK));
    }

}
