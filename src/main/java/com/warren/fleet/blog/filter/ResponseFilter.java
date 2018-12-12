package com.warren.fleet.blog.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "responseFilter",
        urlPatterns = {"/blog/allBlogs","/test/test"})
public class ResponseFilter implements Filter {

    //@ServletComponentScan is required to add on FleetApplication


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        ResponseWrapper wrapper = new ResponseWrapper( (HttpServletResponse)servletResponse );

        filterChain.doFilter(servletRequest,wrapper);

        String content = wrapper.getResponseData( servletResponse.getCharacterEncoding() );

        if(content != null){
            // todo what you want
            content = content.replace(" ","");
        }

        //this line is required to keep the same length
        servletResponse.setContentLength( content.getBytes().length );
        //set the modified content to outputStream
        servletResponse.getOutputStream().write(content.getBytes());

    }

    @Override
    public void destroy() {

    }
}
