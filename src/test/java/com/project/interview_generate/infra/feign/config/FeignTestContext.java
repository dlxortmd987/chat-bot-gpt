package com.project.interview_generate.infra.feign.config;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

import com.project.interview_generate.infra.feign.HeaderConfig;
import com.project.interview_generate.infra.feign.OpenFeignConfig;

@ImportAutoConfiguration({
	OpenFeignConfig.class,
	HeaderConfig.class,
	FeignAutoConfiguration.class,
	HttpMessageConvertersAutoConfiguration.class
})
public class FeignTestContext {
}
