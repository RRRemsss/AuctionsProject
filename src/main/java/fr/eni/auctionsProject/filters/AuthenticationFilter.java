package fr.eni.auctionsProject.filters;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter(
		urlPatterns = { 
				"/ConsultationProfilServlet", 
				"/DeconnexionServlet",
				"/EnchereServlet",
				"/ModificationProfilServlet",
				"/SuppressionProfilServlet",
				"/VenteServlet"
				}, 
		dispatcherTypes = { 
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD,
				DispatcherType.ERROR, 
				DispatcherType.INCLUDE, }
		)
public class AuthenticationFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        
     // Vérifiez si l'utilisateur est connecté
        if (session == null || session.getAttribute("user") == null) {
            // Redirigez vers la page de connexion si l'utilisateur n'est pas connecté
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/LoginServlet");
            return;
        }
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
