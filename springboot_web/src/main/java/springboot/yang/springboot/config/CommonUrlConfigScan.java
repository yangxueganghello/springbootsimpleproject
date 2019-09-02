package springboot.yang.springboot.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:config/commonurl_config.properties" )
@ConfigurationProperties(prefix="config")
@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class CommonUrlConfigScan {
	private String configonetemp;
	private String configtwotemp;
	private String configthreetemp;
	private String configthreetemptest;
}
