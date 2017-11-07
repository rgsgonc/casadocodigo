package br.com.casadocodigo.loja.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controllers.HomeController;
import br.com.casadocodigo.loja.daos.ProdutoDAO;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProdutoDAO.class})
public class AppWebConfiguration {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/views/");
	    resolver.setSuffix(".jsp");
	    return resolver;
	}
	
	
	/*Na classe AppWebConfiguration criaremos um novo método que carregará nossos arquivos de mensagens. Este método 
	 * se chama messageSource e retorna um objeto do tipo MessageSource. Dentro deste método criaremos um objeto do 
	 * tipo ReloadableResourceBundleMessageSource que chamaremos de messageSource. Neste objeto, iremos definir três 
	 * propriedades: setBaseName com o valor /WEB-INF/message que terá o nome base dos nossos resources. 
	 * O setDefaultEncoding com o valor UTF-8 para evitar o problema de caracteres estranhos que já vimos outras vezes 
	 * e o setCacheSeconds para que o Spring recarregue o arquivo de tempos em tempos com o valor 1.*/
	@Bean
	public MessageSource messageSource(){
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("/WEB-INF/messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    messageSource.setCacheSeconds(1);
	    return messageSource;
	}
	
	/*Criaremos então um novo método chamado mvcConversionService que retorna um objeto do tipo FormattingConversionService. 
	 * Dentro deste novo método precisamos fazer duas coisas. A primeira delas é criar um objeto do tipo 
	 * DefaultFormattingConversionService que será o responsável pelo serviço de conversão de formato. A segunda é criar 
	 * um objeto do tipo DateFormatterRegistrar que fará o registro do formato de data usado para a conversão. Este segundo
	 *  objeto espera receber outro objeto do tipo DateFormatter que será quem efetivamente guarda o padrão da data, que 
	 *  neste caso será dd/MM/yyyy, dia/mẽs/ano.*/
	@Bean
	public FormattingConversionService mvcConversionService(){
	    DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
	    DateFormatterRegistrar formatterRegistrar = new DateFormatterRegistrar();
	    formatterRegistrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
	    formatterRegistrar.registerFormatters(conversionService);

	    return conversionService;
	}
}
