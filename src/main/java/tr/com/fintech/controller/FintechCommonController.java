package tr.com.fintech.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tr.com.fintech.common.FilterFieldType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.fintech.common.ErrorCodeType;
import tr.com.fintech.common.OperationType;
import tr.com.fintech.common.PaymentMethodType;
import tr.com.fintech.common.StatusType;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v3/common")
public class FintechCommonController {

    private static final Logger LOG = LoggerFactory.getLogger(FintechCommonController.class);

    @GetMapping(value = "/errorTypes",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ErrorCodeType>> getErrorTypes() {
        return new ResponseEntity<>(Arrays.asList(ErrorCodeType.values()), HttpStatus.OK);
    }

    @GetMapping(value = "/paymentMethods",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PaymentMethodType>> getPaymentMethods() {
        return new ResponseEntity<>(Arrays.asList(PaymentMethodType.values()), HttpStatus.OK);
    }

    @GetMapping(value = "/statusTypes",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StatusType>> getStatusTypes() {
        return new ResponseEntity<>(Arrays.asList(StatusType.values()), HttpStatus.OK);
    }

    @GetMapping(value = "/operationTypes",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OperationType>> getOperationTypes() {
        return new ResponseEntity<>(Arrays.asList(OperationType.values()), HttpStatus.OK);
    }

    @GetMapping(value = "/filterTypes",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FilterFieldType>> getFilterTypes() {
        return new ResponseEntity<>(Arrays.asList(FilterFieldType.values()), HttpStatus.OK);
    }
}
