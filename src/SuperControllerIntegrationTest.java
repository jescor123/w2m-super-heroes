import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

class SuperControllerIntegrationTest {

	@Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
        
    }

    @Test
    public void contextLoads() {

    }
	
	@Test
    public void testShowListAllSuperHeroes() {
    HttpHeaders headers = new HttpHeaders();
       HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/w2m-super-heroes/superheroes/list",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

}
