package pl.krzysztofskul;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import pl.krzysztofskul.numberConverters.BigDecimalConverter;
import pl.krzysztofskul.numberConverters.FloatConverter;
import pl.krzysztofskul.organization.hospital.HospitalConverter;
import pl.krzysztofskul.organization.hospital.department.DepartmentConverter;
import pl.krzysztofskul.organization.hospital.department.room.RoomConverter;
import pl.krzysztofskul.product.ProductConverter;
import pl.krzysztofskul.user.UserConverter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Locale;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.krzysztofskul")
@EnableJpaRepositories(basePackages = "pl.krzysztofskul")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Bean(name="localeResolver")
    public LocaleContextResolver getLocaleContextResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("pl","PL"));
        return localeResolver;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] {"pl.krzysztofskul"});
        em.setJpaDialect(new HibernateJpaDialect());
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(additionalProperties());
        return em;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "drop-and-create");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://localhost:3306/cadmdb?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("@xDpo9Ec16N7&OP0");


//        dataSource.setUrl("jdbc:mysql://"+HerokuConnectionData.getDATABASE());
//        dataSource.setUsername(HerokuConnectionData.getUSER());
//        dataSource.setPassword(HerokuConnectionData.getPASSWORD());

        return dataSource;
    }

    @Bean
    public BigDecimalConverter getBigDecimalConverter() {
        return new BigDecimalConverter();
    }

    @Bean
    public ProductConverter getProductConverter() {
        return new ProductConverter();
    }

    @Bean
    public RoomConverter getRoomConverter() {
        return new RoomConverter();
    }

    @Bean
    public DepartmentConverter getDepartmentConverter() {
        return new DepartmentConverter();
    }

    @Bean
    public HospitalConverter getHospitalConverter() {
        return new HospitalConverter();
    }

    @Bean
    public UserConverter getUserConverter() {
        return new UserConverter();
    }

    @Bean
    public FloatConverter getFloatConverter() {
        return new FloatConverter();
    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addConverter(getBigDecimalConverter());
        formatterRegistry.addConverter(getProductConverter());
        formatterRegistry.addConverter(getRoomConverter());
        formatterRegistry.addConverter(getDepartmentConverter());
        formatterRegistry.addConverter(getHospitalConverter());
        formatterRegistry.addConverter(getUserConverter());
        formatterRegistry.addConverter(getFloatConverter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry handlerRegistry) {
        handlerRegistry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

}
