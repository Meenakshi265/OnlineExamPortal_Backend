package com.examserver.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examserver.services.impl.CustomeUserDeatialsServicveImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthencationFilter  extends OncePerRequestFilter {

	// to get the header from the request .....
	
	@Autowired
	private CustomeUserDeatialsServicveImpl customeUserDeatialsServicveImpl;
	
	
	
	@Autowired
	private   jwtUtil  JwUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 System.out.println("doFilterInternal() method called  from  JwtAuthencationFilter class");
		 final String requestTokenHeader=request.getHeader("Authorization");
		 System.out.println(requestTokenHeader+"............12345566");
		 String userName=null;
		 String jwtToken=null;
		 
		 if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer")) {
			 // token is valid 
			  System.out.println("token vaild hh bhai aage bads");
			 jwtToken=requestTokenHeader.substring(7);
			 System.out.println(jwtToken);  
			 
			try {
				userName= this.JwUtil.extractUsername(jwtToken);
				 System.out.println(userName);
			}
			catch (Exception e) {
			  e.printStackTrace();
			  System.out.println( "error are "+e);
			}
		 }
		 else
		 {
			 System.out.println(" invalid token!!>...........11");
		 }
		 
		 // validated  token ...
		 if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			 UserDetails userDetails=this.customeUserDeatialsServicveImpl.loadUserByUsername(userName);
			 if(this.JwUtil.validateToken(jwtToken, userDetails)) {
				 //token is valid
				 UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
						
				 usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			 }
		 }else {
			 System.out.println("token is not vaild .....................................................................");
		 }
		
		 
		 filterChain.doFilter(request, response);
		 
	    }


	
	
	
	}

