package com.example.demoee;

import static org.mockito.Mockito.*;

import java.io.*;
import jakarta.servlet.http.*;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class HelloServletTest {

    @Mock
    private HttpServletRequest mockRequest;

    @Mock
    private HttpServletResponse mockResponse;

    @Mock
    private PrintWriter mockWriter;

    private HelloServlet helloServlet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        helloServlet = new HelloServlet();
    }

    @Test
    void doGet_shouldWriteHelloWorldMessage() throws IOException {
        when(mockResponse.getWriter()).thenReturn(mockWriter);

        helloServlet.doGet(mockRequest, mockResponse);

        verify(mockResponse).setContentType("text/html");
        verify(mockWriter).println("<html><body>");
        verify(mockWriter).println("<h1>null</h1>");
        verify(mockWriter).println("</body></html>");
    }

    @Test
    void init_shouldInitializeMessage() {
        helloServlet.init();
        Assertions.assertEquals("Hello World!", helloServlet.getMessage());
    }
}

