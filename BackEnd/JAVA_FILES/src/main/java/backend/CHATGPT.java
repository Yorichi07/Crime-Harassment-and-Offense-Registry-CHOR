package backend;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.Scanner;

public class CHATGPT {
    public static void main(String[] args) throws Exception {
        String apiKey = "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";
        String endpoint = "https://api.openai.com/v1/completions";  // Updated_endpoint

        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(endpoint);
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        // Read user input for the prompt
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a prompt: ");
        String userPrompt = scanner.nextLine();

        // Define the prompt as a JSON object
        String requestBody = "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"" + userPrompt + "\"}], \"temperature\": 0.7}";

        httpPost.setEntity(new StringEntity(requestBody));

        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();

        if (responseEntity != null) {
            String responseString = EntityUtils.toString(responseEntity);
            System.out.println(responseString);
        }

        scanner.close();
    }
}

