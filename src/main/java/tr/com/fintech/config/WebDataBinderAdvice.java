package tr.com.fintech.config;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import tr.com.fintech.common.ErrorCodeType;
import tr.com.fintech.common.FilterFieldType;
import tr.com.fintech.common.OperationType;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

@ControllerAdvice
public class WebDataBinderAdvice {
 
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
      @Override
      public void setAsText(String text) throws IllegalArgumentException {
        setValue(LocalDate.parse(text));
      }
    });

   binder.registerCustomEditor(OperationType.class,new PropertyEditorSupport() {
      @Override
      public void setAsText(String text) throws IllegalArgumentException {
        setValue(OperationType.forValue(text));
      }
    });

    binder.registerCustomEditor(ErrorCodeType.class,new PropertyEditorSupport() {
      @Override
      public void setAsText(String text) throws IllegalArgumentException {
        setValue(ErrorCodeType.fromValue(text));
      }
    });
    binder.registerCustomEditor(FilterFieldType.class,new PropertyEditorSupport() {
      @Override
      public void setAsText(String text) throws IllegalArgumentException {
        setValue(FilterFieldType.fromValue(text));
      }
    });
  }
}