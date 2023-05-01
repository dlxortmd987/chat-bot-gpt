package com.project.interview_generate.infra.feign.matgim;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.interview_generate.infra.feign.matgim.dto.MatgimKeywordFeignRequest;
import com.project.interview_generate.infra.feign.matgim.dto.MatgimKeywordFeignResponse;

@FeignClient(name = "MatgimKeyword", url = "${matgim.url}")
public interface MatgimClient {

	@PostMapping
	MatgimKeywordFeignResponse call(
		@RequestBody MatgimKeywordFeignRequest request
	);
}
