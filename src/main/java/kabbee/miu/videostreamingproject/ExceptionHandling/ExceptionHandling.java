package kabbee.miu.videostreamingproject.ExceptionHandling;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

public class ExceptionHandling {
    private String errorMessage;

    private List<String> errorMessagesFromValidity;
    public ExceptionHandling(List<String> errorMessagesFromValidity){
        this.errorMessagesFromValidity=errorMessagesFromValidity;
    }
    public ExceptionHandling(String message){
        this.errorMessage=message;
    }

    @Override
    public String toString() {

        if(errorMessage==null&&errorMessagesFromValidity!=null){
            return errorMessagesFromValidity.toString();
        }else if(errorMessage!=null&&errorMessagesFromValidity==null){
            return errorMessage;
        }

        return
                "errorMessage='" + errorMessage + '\n' +
                ", errorMessagesFromValidity=" + errorMessagesFromValidity  ;
    }
}
