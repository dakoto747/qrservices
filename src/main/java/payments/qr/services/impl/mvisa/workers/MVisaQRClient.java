package payments.qr.services.impl.mvisa.workers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import payments.qr.libs.request.mvisa.MVisaQRServiceRequest;
import payments.qr.libs.response.QRServiceResponse;
import payments.qr.services.impl.mvisa.models.rest.ErrorResponse;
import payments.qr.services.impl.mvisa.models.xml.MerchantPushPaymentsResponse;

@Component
public class MVisaQRClient {

    @Value("${mvisa.api.endpoint.merchant.push.payment}")
    private String merchantPushPaymentsURL;

    @Autowired
    private RestTemplate restTemplate;

    public QRServiceResponse performMerchantPushPayment(MVisaQRServiceRequest mVisaQRServiceRequest){
        /*
        MerchantPushPayments POST
            MerchantPushPayments is used for payment to a merchant for goods or services purchased, either face-to-face or

         */

        try{
            System.out.println(mVisaQRServiceRequest.toString());
            MerchantPushPaymentsResponse merchantPushPaymentsResponse = restTemplate.postForObject(merchantPushPaymentsURL,
                    mVisaQRServiceRequest, MerchantPushPaymentsResponse.class);

            System.out.println("\n\n\n\n\n ############################################### \n ###############################################\n");
            System.out.println(merchantPushPaymentsResponse.toString());
            System.out.println("\n ############################################### \n ###############################################\n\n\n\n\n ");


        } catch (HttpClientErrorException exception){
            System.out.println(exception.getResponseBodyAsString());
            System.out.println(exception.getLocalizedMessage());
        }

//        visaAPIClient.doXPayTokenRequest(merchantPushPaymentsURL, "", )

        return new QRServiceResponse();
    }

}
