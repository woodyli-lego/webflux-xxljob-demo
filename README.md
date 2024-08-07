# webflux-xxl-job-demo

## 环境准备

```shell
make infra-start
```

## 配置 xxl-job

http://localhost:8000/xxl-job-admin

添加 executor: webflux-xxljob

添加 job: myTestJob

## 测试

启动项目，在 myTestJob 执行期间，访问 `GET /ping`，可以访问，说明 xxl-job 并没有 block event loop。