# dubboxside
A Dubbox Framework based, pragmatic style REST + Http application architecture.


[![build status](https://camo.githubusercontent.com/4682ba0db83744e99d8d50f0d71e36069181b21c/68747470733a2f2f7472617669732d63692e6f72672f737072696e672f737072696e672e7376673f6272616e63683d646576656c6f70)](http://192.168.20.36/v2/passport/tree/v1.1.x)

# 项目结构解析

    |root
    --|showcase-api                 服务统一接口(Dubbo协议接口)
    --|showcase-commons             公共包(工具类,常量等)
    --|showcase-assembly            打assembly包直接运行
    --|showcase-customer            消费者
    --|showcase-facade-api          服务统一接口(Http+REST协议)
    --|showcase-provider            Dubbo协议具体实现
    --|showcase-facade-provider     REST协议实现(底层引用passport-provider的实现接口)
    --|showcase-web                   War包


# 如何使用

* Http + REST调用方式

    * PHP

    ```
        //TODO

    ```

    * JAVA

    ```
       /**
        * 注册
        */
       @Test
       public void testRegister () {

           // 请求参数
           Map<String, String> params = Maps.newHashMap();
           params.put("passport", "username");
           params.put("password", "password");

           // 发送请求
           HttpRequests.request(registerUrl, JSON.toJSONString(params), httpResponse, false);

           // 请求状态吗
           int requestCode = httpResponse.getStatusCode();

           Assert.assertEquals(HttpStatus.SC_OK, requestCode);

           // 请求结果
           String result = httpResponse.getResult();

           // 反序列化成对象
           Result responseObject = Result.decode(result.getBytes(), Result.class);

           // print
           responseObject.print();

       }

    ```

* Dubbo消费端消费


    ```
        依赖


        <dependency>
            <groupId>xyz.vopen.passport</groupId>
            <artifactId>passport-api</artifactId>
            <version>1.1.0</version>
        </dependency>

    ```

    ```
        配置文件配置


        <!-- 引用服务提供者消费接口 -->
        <dubbo:reference id="passportService" interface="xyz.vopen.passport.service.PassportService"/>

    ```

    ```
        JAVA Code Useage:


        /**
         * 声明需要调用的远程接口类
         */
        private PassportService passportService;


        /**
         * 提供Setter方法
         * @param passportService service instance
         */
        public void setPassportService (PassportService passportService) {
            this.passportService = passportService;
        }


        /**
         * 测试注册
         */
        public void testRegister () {
            // 本地调用一样去使用
            Authorizer authorizer = passportService.register(requester, username, password, passwordType);
            if (authorizer != null) {
                authorizer.print();
            }
        }

    ```



## 服务配置文件
    ```
    <!-- Dubbo Application相关配置 -->
    <dubbo:application name="${dubbo.application.name}" owner="passport" organization="pyw"/>
    <dubbo:registry address="${dubbo.zookeeper.url}"/>
    <dubbo:monitor protocol="registry"/>
    <dubbo:annotation package="xyz.vopen.passport"/>

    <!-- dubbo 协议配置 -->
    <dubbo:protocol name="dubbo"
                    serialization="kryo"
                    optimizer="xyz.vopen.passport.serial.SerializationOptimizerImpl"/>

    <!-- REST 协议配置 -->
    <dubbo:protocol name="rest"
                    port="${dubbo.protocol.port}"
                    contextpath="${dubbo.application.context.path}"
                    server="${dubbo.protocol.server}"
                    extension="xyz.vopen.passport.facade.filter.AccessPermissionFilter"
    />

    ```

##  消费者调用
    ```
    略
    ```
