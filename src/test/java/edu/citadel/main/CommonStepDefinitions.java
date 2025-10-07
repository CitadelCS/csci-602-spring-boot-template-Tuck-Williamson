package edu.citadel.main;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonStepDefinitions extends SpringIntegrationTest{

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;

    @When("^the client calls /(\\w+)$")
    public void callInfoEndpoint(String endpoint)
    {
        response = restTemplate.getForEntity("/" + endpoint, String.class);
    }

    @Then("^the client receives status code of (\\d+)$")
    public void checkStatusCode(int statusCode)
    {
        assert response.getStatusCode().value() == statusCode;
    }

    @Then("^the client receives server name, version, and description$")
    public void checkBody()
    {
        assert response.getBody() != null;
        assert response.getBody().contains("name");
        assert response.getBody().contains("version");
        assert response.getBody().contains("description");
    }

    @Then("^the client receives a map with (\\w+) equal to (\\w+)")
    public void testMapValue(String key, String value){
        assert response.getBody() != null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            var jsonMap = mapper.readValue(response.getBody(), Map.class);
            assert jsonMap.get(key).equals(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON response", e);
        }
    }

    @Then("^the client receives a map with (\\w+) equal to (\\d+).(\\d+).(\\d+)")
    public void testMapValue(String key, int major, int minor, int patch){
        assert response.getBody() != null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            var jsonMap = mapper.readValue(response.getBody(), Map.class);
            assert jsonMap.get(key).equals(major + "." + minor + "." + patch);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON response", e);
        }
    }


}



