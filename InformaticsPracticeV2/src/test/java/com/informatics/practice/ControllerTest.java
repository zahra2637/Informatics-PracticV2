package com.informatics.practice;
import com.informatics.practice.app.repository.PersonDto;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class ControllerTest extends AbstractTest {
    public static final String TEST_REQUEST_URL = "https://localhost:8080/api/list";
    public static final String CREATE_REQUEST_URL ="http://localhost:8080/api/create";
    public static final String GET_REQUEST_URL = "http://localhost:8080/api/get";
    public static final String DELETE_REQUEST_URL ="http://localhost:8080/api/delete?personId=1";
    @Override
    public void setUp() {
        super.setUp();
    }
    @Test
    void testTest() throws Exception {
        PersonDto request = new PersonDto();
        request.setFirstName("pegah");
        request.setLastName("jafari");
        request.setAge(20);
        int response = super.getRequestTest(TEST_REQUEST_URL, request);
        Assertions.assertEquals(HttpServletResponse.SC_OK, response);
    }
    @Test
    void createTest() throws Exception {
        PersonDto request = new PersonDto();
        request.setFirstName("pegah");
        request.setLastName("jafari");
        request.setAge(20);
        int response = super.postRequestTest(CREATE_REQUEST_URL, request);
        Assertions.assertEquals(HttpServletResponse.SC_OK, response);
    }
    @Test
    void deleteTest() throws Exception {
        Long id= 1L;
        int response = super.deleteRequestTest(DELETE_REQUEST_URL, id);
        Assertions.assertEquals(HttpServletResponse.SC_OK, response);
    }
    @Test
    void findAllTest() throws Exception {
        int response = super.findAllRequestTest(GET_REQUEST_URL);
        Assertions.assertEquals(HttpServletResponse.SC_OK, response);
    }
    @Test
    void nullFirstNameTest() throws Exception {
        PersonDto request = new PersonDto();
        request.setFirstName(null);
        request.setLastName(RandomStringUtils.randomNumeric(8));
        request.setAge(20);
        int response = super.postRequestTest(CREATE_REQUEST_URL, request);
        Assertions.assertEquals(HttpServletResponse.SC_BAD_REQUEST, response);
    }
    @Test
    void nullLastNameTest() throws Exception {
        PersonDto request = new PersonDto();
        request.setFirstName(RandomStringUtils.randomNumeric(5));
        request.setLastName(null);
        request.setAge(20);
        int response = super.postRequestTest(CREATE_REQUEST_URL, request);
        Assertions.assertEquals(HttpServletResponse.SC_BAD_REQUEST, response);
    }

}
