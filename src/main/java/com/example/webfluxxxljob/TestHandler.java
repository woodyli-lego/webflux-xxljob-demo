package com.example.webfluxxxljob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component
public class TestHandler {

    @XxlJob("myTestJob")
    @SneakyThrows
    public ReturnT<String> testJob() {
        String param = XxlJobHelper.getJobParam();
        log.info("Job started with param: {}", param);
        Thread.sleep(Duration.ofSeconds(5));
        log.info("Job completed");
        return ReturnT.SUCCESS;
    }
}
