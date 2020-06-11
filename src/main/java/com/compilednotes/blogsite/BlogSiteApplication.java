package com.compilednotes.blogsite;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
//@ImportResource({"classpath*:dozerBeanMapping.xml"})
public class BlogSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogSiteApplication.class, args);
	}

	//@Bean(name = "org.dozer.Mapper")
	public DozerBeanMapper dozerBean() {
		List<String> mappingFiles = Arrays.asList(
				"dozerBeanMapping.xml"
		);

		DozerBeanMapper dozerBean = new DozerBeanMapper();
		dozerBean.setMappingFiles(mappingFiles);
		return dozerBean;
	}

}
