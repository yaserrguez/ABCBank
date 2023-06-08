/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 9:18 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Slf4j
@Component
public class RequestTimeInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    {
        log.info("[preHandle][" + request.getMethod() + "][" + request.getRequestURL().toString() + " " + getParameters(request) + "]");
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    {
        if (ex != null)
        {
            log.info("[afterCompletion][" + request.getMethod() + "] [" + request.getRequestURL().toString() + "][exception: " + ex + "]");
        }
        long startTime = (long) request.getAttribute("startTime");
        log.info("[afterCompletion][" + request.getMethod() + "] [" + request.getRequestURL().toString() + "] [" + response.getStatus() + "] [" + (System.currentTimeMillis() - startTime) + "ms]");
    }

    private String getParameters(HttpServletRequest request)
    {
        StringBuffer posted = new StringBuffer();
        Enumeration<?> e = request.getParameterNames();
        if (e != null)
        {
            posted.append("?");
        }
        while (e.hasMoreElements())
        {
            if (posted.length() > 1)
            {
                posted.append("&");
            }
            String curr = (String) e.nextElement();
            posted.append(curr + "=");
            if (curr.contains("password") || curr.contains("pass") || curr.contains("pwd"))
            {
                posted.append("*****");
            }
            else
            {
                posted.append(request.getParameter(curr));
            }
        }
        String ip = request.getHeader("X-FORWARDED-FOR");
        String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;
        if (ipAddr!=null && !ipAddr.equals(""))
        {
            posted.append("&_psip=" + ipAddr);
        }
        return posted.toString();
    }

    private String getRemoteAddr(HttpServletRequest request)
    {
        String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
        if (ipFromHeader != null && ipFromHeader.length() > 0)
        {
            log.debug("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
            return ipFromHeader;
        }
        return request.getRemoteAddr();
    }
}
