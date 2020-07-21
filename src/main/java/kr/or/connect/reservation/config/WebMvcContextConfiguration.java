package kr.or.connect.reservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"kr.or.connect.reservation.controller"})
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	//url에 따라서 불러오는 파일 설정
		public void addResourceHandler(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
	        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
	        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
	        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
		}
		
	    // default servlet handler를 사용하게 합니다.
		//mapping정보가 없는 url정보가 들어왔을때 spring의 defaultServletHTTPRequestHandle이 처리하도록
	    @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	    
	    @Override
	    //특정 url에 대한 처리를 컨트롤러 클래스를 작성하지 않고 매핑할 수 있도록 해주는 부분
	    public void addViewControllers(final ViewControllerRegistry registry) {
	    		System.out.println("addViewControllers가 호출됩니다. ");
	        registry.addViewController("/").setViewName("mainpage"); // /라는 요청이 들어오면 index라는 이름의 뷰로 보여주세요라고 설정
	    }
		
	    @Bean
	    public InternalResourceViewResolver getInternalResourceViewResolver() { //어떤 view인지에 대한 정보
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/views/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }
}
