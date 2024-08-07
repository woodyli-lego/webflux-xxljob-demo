package com.example.webfluxxxljob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component
@RequiredArgsConstructor
public class TestHandler {

    private final TestClient testClient;

    @XxlJob("myTestJob")
    @SneakyThrows
    public ReturnT<String> testJob() {
        String param = XxlJobHelper.getJobParam();
        log.info("Job started with param: {}", param);
        String result = testClient.get().block();
        log.info("Job completed with result: {}", result.length());
        return ReturnT.SUCCESS;
    }
}
