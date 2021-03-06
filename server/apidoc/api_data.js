define({ "api": [
  {
    "type": "get",
    "url": "/delete/maintenance/company?maintenanceCompanyId=1",
    "title": "删除维保公司信息",
    "version": "0.0.1",
    "description": "<p>基础数据之删除维保公司信息的接口。</p>",
    "group": "Basic_data-维保公司",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "maintenanceCompanyId",
            "description": "<p>维保公司ID（唯一识别）</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-删除成功；1201-请求条件中，缺少ID参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"删除成功\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\",\n\t   \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/MaintenanceCompanyController.java",
    "groupTitle": "Basic_data-维保公司",
    "name": "GetDeleteMaintenanceCompanyMaintenancecompanyid1",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/delete/maintenance/company?maintenanceCompanyId=1"
      }
    ]
  },
  {
    "type": "get",
    "url": "/select/maintenance/company?maintenanceCompanyId=3",
    "title": "查询维保公司信息",
    "version": "0.0.1",
    "description": "<p>基础数据之查询维保公司信息的接口。</p>",
    "group": "Basic_data-维保公司",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "maintenanceCompanyId",
            "description": "<p>维保公司ID（唯一识别）</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"maintenanceCompanyId\": 3,\n        \"companyCode\": null,\n        \"companyName\": \"你好公司\",\n        \"businessLicense\": \"124359806\",\n        \"legalRepresentative\": \"张三\",\n        \"phone\": \"18630992356\",\n        \"address\": \"广东省广州市\",\n        \"lngandlat\": \"(113.23, 23.16)\",\n        \"level\": \"第一等级\",\n        \"insertTime\": null,\n        \"updateTime\": \"2021-04-05 20:31:20.0\",\n        \"idDeleted\": null,\n        \"isRecommend\": null,\n        \"memberId\": null,\n        \"adminCode\": \"440100\",\n        \"dispatchNum\": 0\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2001,\n\t\"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/MaintenanceCompanyController.java",
    "groupTitle": "Basic_data-维保公司",
    "name": "GetSelectMaintenanceCompanyMaintenancecompanyid3",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/select/maintenance/company?maintenanceCompanyId=3"
      }
    ]
  },
  {
    "type": "post",
    "url": "/add/maintenance/company",
    "title": "创建维保公司信息",
    "version": "0.0.1",
    "description": "<p>基础数据之生成维保公司信息的接口。</p>",
    "group": "Basic_data-维保公司",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "companyName",
            "description": "<p>公司名称</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "businessLicense",
            "description": "<p>营业执照</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "legalRepresentative",
            "description": "<p>法人代表</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>联系电话</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>地址</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "lngAndLat",
            "description": "<p>经纬度</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "level",
            "description": "<p>等级</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "adminCode",
            "description": "<p>行政区域编码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"companyName\": \"你好公司\",\n    \"businessLicense\": \"124359806\",\n    \"legalRepresentative\": \"张三\",\n    \"phone\": \"18630992356\",\n    \"address\": \"广东省广州市\",\n    \"lngAndLat\": \"(113.23, 23.16)\",\n    \"level\": \"第一等级\",\n    \"adminCode\": \"440100\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-创建成功；2003-生成数据失败；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "maintenanceCompanyId",
            "description": "<p>维保公司ID（唯一识别）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"创建成功\",\n    \"data\": {\n        \"maintenanceCompanyId\": 3,\n        \"companyCode\": null,\n        \"companyName\": \"你好公司\",\n        \"businessLicense\": \"124359806\",\n        \"legalRepresentative\": \"张三\",\n        \"phone\": \"18630992356\",\n        \"address\": \"广东省广州市\",\n        \"lngandlat\": \"(113.23, 23.16)\",\n        \"level\": \"第一等级\",\n        \"insertTime\": null,\n        \"updateTime\": \"2021-04-05 20:31:20\",\n        \"idDeleted\": null,\n        \"isRecommend\": null,\n        \"memberId\": null,\n        \"adminCode\": \"440100\",\n        \"dispatchNum\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2003,\n\t\"Message\": \"生成数据失败\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/MaintenanceCompanyController.java",
    "groupTitle": "Basic_data-维保公司",
    "name": "PostAddMaintenanceCompany",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/add/maintenance/company"
      }
    ]
  },
  {
    "type": "post",
    "url": "/update/maintenance/company",
    "title": "更新维保公司信息",
    "version": "0.0.1",
    "description": "<p>基础数据之更新维保公司信息的接口。</p>",
    "group": "Basic_data-维保公司",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "maintenanceCompanyId",
            "description": "<p>维保公司ID（唯一识别，必填）</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "companyName",
            "description": "<p>公司名称</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "businessLicense",
            "description": "<p>营业执照</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "legalRepresentative",
            "description": "<p>法人代表</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>联系电话</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>地址</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "lngAndLat",
            "description": "<p>经纬度</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "level",
            "description": "<p>等级</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "adminCode",
            "description": "<p>行政区域编码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"maintenanceCompanyId\": 3,\n    \"companyName\": \"你好公司啊\",\n    \"businessLicense\": \"124359806\",\n    \"legalRepresentative\": \"张三\",\n    \"phone\": \"18630992356\",\n    \"address\": \"广东省广州市\",\n    \"lngAndLat\": \"(113.23, 23.16)\",\n    \"level\": \"第一等级\",\n    \"adminCode\": \"440100\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-更新成功；2003-更新失败；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"更新成功\",\n    \"data\": {\n        \"maintenanceCompanyId\": 3,\n        \"companyCode\": null,\n        \"companyName\": \"你好公司啊\",\n        \"businessLicense\": \"124359806\",\n        \"legalRepresentative\": \"张三\",\n        \"phone\": \"18630992356\",\n        \"address\": \"广东省广州市\",\n        \"lngandlat\": \"(113.23, 23.16)\",\n        \"level\": \"第一等级\",\n        \"insertTime\": null,\n        \"updateTime\": \"2021-04-06 22:27:16\",\n        \"idDeleted\": null,\n        \"isRecommend\": null,\n        \"memberId\": null,\n        \"adminCode\": \"440100\",\n        \"dispatchNum\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2003,\n\t\"Message\": \"更新失败\",\n\t\"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/MaintenanceCompanyController.java",
    "groupTitle": "Basic_data-维保公司",
    "name": "PostUpdateMaintenanceCompany",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/update/maintenance/company"
      }
    ]
  },
  {
    "type": "post",
    "url": "/add/maintenance/staff",
    "title": "创建维保公司员工信息",
    "version": "0.0.1",
    "description": "<p>基础数据之生成维保公司员工信息的接口。</p>",
    "group": "Basic_data-维保员工",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>员工工号（唯一识别，必填）</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>员工姓名</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "age",
            "description": "<p>年龄</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "sex",
            "description": "<p>性别</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>联系电话</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>公司ID</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "cardNum",
            "description": "<p>身份证号</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"id\": 111105,\n    \"name\": \"你好公司员工5号\",\n    \"age\": 30,\n    \"sex\": \"男\",\n    \"phone\": \"15768042390\",\n    \"companyId\": 1,\n    \"cardNum\": \"410823198607126060\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-成功；2003-生成数据失败；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"创建成功\",\n    \"data\": {\n        \"id\": 111105,\n        \"name\": \"你好公司员工5号\",\n        \"age\": 30,\n        \"sex\": \"男\",\n        \"phone\": \"15768042390\",\n        \"companyId\": 1,\n        \"cardNum\": \"410823198607126060\",\n        \"update\": \"2021-04-05 21:29:57\",\n        \"cleaningNum\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2003,\n\t\"Message\": \"生成数据失败\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/MaintenanceStaffController.java",
    "groupTitle": "Basic_data-维保员工",
    "name": "PostAddMaintenanceStaff",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/add/maintenance/staff"
      }
    ]
  },
  {
    "type": "post",
    "url": "/delete/maintenance/staff",
    "title": "删除维保公司员工信息",
    "version": "0.0.1",
    "description": "<p>基础数据之删除维保公司员工信息的接口。</p>",
    "group": "Basic_data-维保员工",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>维保公司员工工号ID（唯一识别）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"id\": 111105\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-删除成功；1201-请求条件中，缺少ID参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"删除成功\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/MaintenanceStaffController.java",
    "groupTitle": "Basic_data-维保员工",
    "name": "PostDeleteMaintenanceStaff",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/delete/maintenance/staff"
      }
    ]
  },
  {
    "type": "post",
    "url": "/select/maintenance/staff",
    "title": "查询维保公司员工信息",
    "version": "0.0.1",
    "description": "<p>基础数据之查询维保公司员工信息的接口。</p>",
    "group": "Basic_data-维保员工",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>员工工号（唯一识别），或：此值为空查询所有员工</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"id\": 111105\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "boolean",
            "optional": false,
            "field": "ifLeave",
            "description": "<p>是否请假（false：没有  true：请假）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"id\": 111105,\n        \"name\": \"你好公司员工5号\",\n        \"age\": 30,\n        \"sex\": \"男\",\n        \"phone\": \"15768042390\",\n        \"companyId\": 1,\n        \"cardNum\": \"410823198607126060\",\n        \"update\": \"2021-04-05 21:29:57.0\",\n        \"ifLeave\": false,\n        \"dispatchNum\": 0,\n        \"leaveStartTime\": null,\n        \"leaveEndTime\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2001,\n\t\"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/MaintenanceStaffController.java",
    "groupTitle": "Basic_data-维保员工",
    "name": "PostSelectMaintenanceStaff",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/select/maintenance/staff"
      }
    ]
  },
  {
    "type": "post",
    "url": "/update/maintenance/staff",
    "title": "更新维保公司员工信息",
    "version": "0.0.1",
    "description": "<p>基础数据之更新维保公司员工信息的接口。</p>",
    "group": "Basic_data-维保员工",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>员工工号（唯一识别，必填）</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>员工姓名</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "age",
            "description": "<p>年龄</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "sex",
            "description": "<p>性别</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>联系电话</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>公司ID</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "cardNum",
            "description": "<p>身份证号</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"id\": 111105,\n    \"name\": \"你好公司员工5号！！\",\n    \"age\": 30,\n    \"sex\": \"男\",\n    \"phone\": \"15768042390\",\n    \"companyId\": 1,\n    \"cardNum\": \"410823198607126060\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-更新成功；2003-更新失败；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"更新成功\",\n    \"data\": {\n        \"id\": 111105,\n        \"name\": \"你好公司员工5号！！\",\n        \"age\": 30,\n        \"sex\": \"男\",\n        \"phone\": \"15768042390\",\n        \"companyId\": 1,\n        \"cardNum\": \"410823198607126060\",\n        \"update\": \"2021-04-06 22:33:18\",\n        \"ifLeave\": null,\n        \"dispatchNum\": null,\n        \"leaveStartTime\": null,\n        \"leaveEndTime\": null,\n        \"idDeleted\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2003,\n\t\"Message\": \"更新失败\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/MaintenanceStaffController.java",
    "groupTitle": "Basic_data-维保员工",
    "name": "PostUpdateMaintenanceStaff",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/update/maintenance/staff"
      }
    ]
  },
  {
    "type": "get",
    "url": "/delete/operation/company?operationCompanyId=1",
    "title": "删除运维公司信息",
    "version": "0.0.1",
    "description": "<p>基础数据之删除运维公司信息的接口。</p>",
    "group": "Basic_data-运维公司",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "operationCompanyId",
            "description": "<p>运维公司ID（唯一识别）</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-删除成功；1201-请求条件中，缺少ID参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"删除成功\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\",\n\t   \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OperationCompanyController.java",
    "groupTitle": "Basic_data-运维公司",
    "name": "GetDeleteOperationCompanyOperationcompanyid1",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/delete/operation/company?operationCompanyId=1"
      }
    ]
  },
  {
    "type": "get",
    "url": "/select/operation/company?operationCompanyId=1",
    "title": "查询单/多个运维公司信息",
    "version": "0.0.1",
    "description": "<p>基础数据之查询运维公司信息的接口，若查询所有运维公司信息不传值即可，即 /select/operation/company?operationCompanyId=</p>",
    "group": "Basic_data-运维公司",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "operationCompanyId",
            "description": "<p>运维公司ID</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-创建成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "operationCompanies",
            "description": "<p>运维公司数组</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"operationCompanies\": [\n            {\n                \"operationCompanyId\": 1,\n                \"companyCode\": \"ss\",\n                \"companyName\": \"运维1\",\n                \"businessLicense\": \"\",\n                \"legalRepresentative\": \"\",\n                \"phone\": \"\",\n                \"address\": \"\",\n                \"lngandlat\": \"110.306176,25.285181\",\n                \"level\": \"\",\n                \"insertTime\": \"2021-06-20 17:01:07.0\",\n                \"updateTime\": null,\n                \"isDeleted\": false,\n                \"isRecommend\": false,\n                \"adminCode\": \"450000,450300,450305\",\n                \"dispatchNum\": null\n            },\n            {\n                \"operationCompanyId\": 2,\n                \"companyCode\": \"tt\",\n                \"companyName\": \"ww\",\n                \"businessLicense\": \"asd\",\n                \"legalRepresentative\": \"s\",\n                \"phone\": \"15875465254\",\n                \"address\": \"ad\",\n                \"lngandlat\": \"110.306176,25.285181\",\n                \"level\": \"2\",\n                \"insertTime\": \"2021-06-20 17:01:11.0\",\n                \"updateTime\": null,\n                \"isDeleted\": false,\n                \"isRecommend\": false,\n                \"adminCode\": \"sad\",\n                \"dispatchNum\": null\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2001,\n\t\"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OperationCompanyController.java",
    "groupTitle": "Basic_data-运维公司",
    "name": "GetSelectOperationCompanyOperationcompanyid1",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/select/operation/company?operationCompanyId=1"
      }
    ]
  },
  {
    "type": "post",
    "url": "/add/operation/company",
    "title": "创建运维公司信息",
    "version": "0.0.1",
    "description": "<p>基础数据之生成运维公司信息的接口。</p>",
    "group": "Basic_data-运维公司",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "companyName",
            "description": "<p>公司名称</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "businessLicense",
            "description": "<p>营业执照</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "legalRepresentative",
            "description": "<p>法人代表</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>联系电话</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>地址</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "lngAndLat",
            "description": "<p>经纬度</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "level",
            "description": "<p>等级</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "adminCode",
            "description": "<p>行政区域编码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"companyName\": \"运维公司\",\n    \"businessLicense\": \"124359806\",\n    \"legalRepresentative\": \"周\",\n    \"phone\": \"18630992356\",\n    \"address\": \"广西桂林\",\n    \"lngAndLat\": \"(113.23, 23.16)\",\n    \"level\": \"第一等级\",\n    \"adminCode\": \"440100\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-创建成功；2003-生成数据失败；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "operationCompanyId",
            "description": "<p>运维公司Id（唯一识别）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"创建成功\",\n    \"data\": {\n        \"operationCompanyId\": 1,\n        \"companyCode\": null,\n        \"companyName\": \"运维公司\",\n        \"businessLicense\": \"124359806\",\n        \"legalRepresentative\": \"周\",\n        \"phone\": \"18630992356\",\n        \"address\": \"广西桂林\",\n        \"lngandlat\": \"(113.23, 23.16)\",\n        \"level\": \"第一等级\",\n        \"insertTime\": null,\n        \"updateTime\": \"2021-04-05 20:55:38\",\n        \"idDeleted\": null,\n        \"isRecommend\": null,\n        \"adminCode\": \"440100\"\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2003,\n\t\"Message\": \"生成数据失败\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OperationCompanyController.java",
    "groupTitle": "Basic_data-运维公司",
    "name": "PostAddOperationCompany",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/add/operation/company"
      }
    ]
  },
  {
    "type": "post",
    "url": "/update/operation/company",
    "title": "更新运维公司信息",
    "version": "0.0.1",
    "description": "<p>基础数据之更新运维公司信息的接口。</p>",
    "group": "Basic_data-运维公司",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "operationCompanyId",
            "description": "<p>运维公司ID（唯一识别）</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "companyName",
            "description": "<p>公司名称</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "businessLicense",
            "description": "<p>营业执照</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "legalRepresentative",
            "description": "<p>法人代表</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>联系电话</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>地址</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "lngAndLat",
            "description": "<p>经纬度</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "level",
            "description": "<p>等级</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "adminCode",
            "description": "<p>行政区域编码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"operationCompanyId\": 1,\n    \"companyName\": \"运维公司！！\",\n    \"businessLicense\": \"124359806\",\n    \"legalRepresentative\": \"周\",\n    \"phone\": \"18630992356\",\n    \"address\": \"广西桂林\",\n    \"lngAndLat\": \"(113.23, 23.16)\",\n    \"level\": \"第一等级\",\n    \"adminCode\": \"440100\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-更新成功；2003-更新失败；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"更新成功\",\n    \"data\": {\n        \"operationCompanyId\": 1,\n        \"companyCode\": null,\n        \"companyName\": \"运维公司！！\",\n        \"businessLicense\": \"124359806\",\n        \"legalRepresentative\": \"周\",\n        \"phone\": \"18630992356\",\n        \"address\": \"广西桂林\",\n        \"lngandlat\": \"(113.23, 23.16)\",\n        \"level\": \"第一等级\",\n        \"insertTime\": null,\n        \"updateTime\": \"2021-04-06 22:35:16\",\n        \"idDeleted\": null,\n        \"isRecommend\": null,\n        \"adminCode\": \"440100\"\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2003,\n\t\"Message\": \"更新失败\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OperationCompanyController.java",
    "groupTitle": "Basic_data-运维公司",
    "name": "PostUpdateOperationCompany",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/update/operation/company"
      }
    ]
  },
  {
    "type": "post",
    "url": "/add/operation/staff",
    "title": "创建运维公司员工信息",
    "version": "0.0.1",
    "description": "<p>基础数据之生成运维公司员工信息的接口。</p>",
    "group": "Basic_data-运维员工",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>员工工号（唯一识别，必填）</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>员工姓名</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "age",
            "description": "<p>年龄</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "sex",
            "description": "<p>性别</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>联系电话</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>公司ID</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "cardNum",
            "description": "<p>身份证号</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"id\": 67910,\n    \"name\": \"大运维公司员工3号\",\n    \"age\": 31,\n    \"sex\": \"女\",\n    \"phone\": \"15768042390\",\n    \"companyId\": 2,\n    \"cardNum\": \"410823198607126060\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-成功；2003-生成数据失败；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"创建成功\",\n    \"data\": {\n        \"id\": 67910,\n        \"name\": \"大运维公司员工3号\",\n        \"age\": 31,\n        \"sex\": \"女\",\n        \"phone\": \"15768042390\",\n        \"companyId\": 2,\n        \"cardNum\": \"410823198607126060\",\n        \"update\": \"2021-04-09 22:51:52.0\",\n        \"ifLeave\": false,\n        \"dispatchNum\": 0,\n        \"leaveStartTime\": null,\n        \"leaveEndTime\": null,\n        \"idDeleted\": false\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2003,\n\t\"Message\": \"生成数据失败\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OperationStaffController.java",
    "groupTitle": "Basic_data-运维员工",
    "name": "PostAddOperationStaff",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/add/operation/staff"
      }
    ]
  },
  {
    "type": "post",
    "url": "/delete/operation/staff",
    "title": "删除运维公司员工信息",
    "version": "0.0.1",
    "description": "<p>基础数据之删除运维公司员工信息的接口。</p>",
    "group": "Basic_data-运维员工",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>运维公司员工工号ID（唯一识别）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"id\": 57986\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-删除成功；1201-请求条件中，缺少ID参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"删除成功\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OperationStaffController.java",
    "groupTitle": "Basic_data-运维员工",
    "name": "PostDeleteOperationStaff",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/delete/operation/staff"
      }
    ]
  },
  {
    "type": "post",
    "url": "/select/operation/staff",
    "title": "查询运维公司员工信息",
    "version": "0.0.1",
    "description": "<p>基础数据之查询运维公司员工信息的接口。</p>",
    "group": "Basic_data-运维员工",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>员工工号（唯一识别），或：此值为空查询所有员工</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"id\": 57986\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "boolean",
            "optional": false,
            "field": "ifLeave",
            "description": "<p>是否请假（false：没有  true：请假）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"ostaffList\": [\n            {\n                \"id\": 57986,\n                \"name\": \"大运维公司员工1号！！\",\n                \"age\": 30,\n                \"sex\": \"男\",\n                \"phone\": \"15768042390\",\n                \"companyId\": 1,\n                \"cardNum\": \"410823198607126060\",\n                \"update\": \"2021-04-09 23:15:42.0\",\n                \"ifLeave\": false,\n                \"dispatchNum\": 0,\n                \"leaveStartTime\": null,\n                \"leaveEndTime\": null,\n                \"idDeleted\": false\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2001,\n\t\"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OperationStaffController.java",
    "groupTitle": "Basic_data-运维员工",
    "name": "PostSelectOperationStaff",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/select/operation/staff"
      }
    ]
  },
  {
    "type": "post",
    "url": "/update/operation/staff",
    "title": "更新运维公司员工信息",
    "version": "0.0.1",
    "description": "<p>基础数据之更新运维公司员工信息的接口。</p>",
    "group": "Basic_data-运维员工",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>员工工号（唯一识别，必填）</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>员工姓名</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "age",
            "description": "<p>年龄</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "sex",
            "description": "<p>性别</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>联系电话</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>公司ID</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "cardNum",
            "description": "<p>身份证号</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"id\": 57986,\n    \"name\": \"大运维公司员工1号！！\",\n    \"age\": 30,\n    \"sex\": \"男\",\n    \"phone\": \"15768042390\",\n    \"companyId\": 1,\n    \"cardNum\": \"410823198607126060\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-更新成功；2003-更新失败；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"更新成功\",\n    \"data\": {\n        \"id\": 57986,\n        \"name\": \"大运维公司员工1号！！\",\n        \"age\": 30,\n        \"sex\": \"男\",\n        \"phone\": \"15768042390\",\n        \"companyId\": 1,\n        \"cardNum\": \"410823198607126060\",\n        \"update\": \"2021-04-09 23:15:42.0\",\n        \"ifLeave\": false,\n        \"dispatchNum\": 0,\n        \"leaveStartTime\": null,\n        \"leaveEndTime\": null,\n        \"idDeleted\": false\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2003,\n\t\"Message\": \"更新失败\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OperationStaffController.java",
    "groupTitle": "Basic_data-运维员工",
    "name": "PostUpdateOperationStaff",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/update/operation/staff"
      }
    ]
  },
  {
    "type": "get",
    "url": "/select/food/company?companyId=4",
    "title": "查询单/多个餐饮企业信息",
    "version": "0.0.1",
    "description": "<p>基础数据之查询餐饮企业信息的接口，若查询所有餐饮企业不传值即可，即 /select/food/company?companyId=</p>",
    "group": "Basic_data-餐饮企业",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>餐饮企业ID（唯一识别）</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "foodCompanies",
            "description": "<p>餐饮企业数组</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"foodCompanies\": [\n            {\n                \"companyId\": 1,\n                \"memberId\": null,\n                \"companyCode\": \"food1\",\n                \"companyName\": \"六三好食在·柴火妈妈饭\",\n                \"businessLicense\": \"\",\n                \"legalRepresentative\": \"李湘太\",\n                \"phone\": \"15078327874\",\n                \"address\": \"广西壮族自治区桂林市七星区空明西路27号\",\n                \"lngandlat\": \"110.262663,25.269412\",\n                \"isDeleted\": false,\n                \"insertTime\": null,\n                \"updateTime\": \"2021-07-10 20:18:32.0\",\n                \"level\": \"4\",\n                \"isRecommend\": null,\n                \"adminCode\": \"450000,450300,450305\",\n                \"currentMaintenceBatch\": null\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2001,\n\t\"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/FoodCompanyController.java",
    "groupTitle": "Basic_data-餐饮企业",
    "name": "GetSelectFoodCompanyCompanyid4",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/select/food/company?companyId=4"
      }
    ]
  },
  {
    "type": "post",
    "url": "/add/food/company",
    "title": "创建餐饮企业信息",
    "version": "0.0.1",
    "description": "<p>基础数据之生成餐饮企业信息的接口。</p>",
    "group": "Basic_data-餐饮企业",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "companyName",
            "description": "<p>餐饮企业名称</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "businessLicense",
            "description": "<p>营业执照</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "legalRepresentative",
            "description": "<p>法人代表</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>联系电话</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>地址</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "lngAndLat",
            "description": "<p>经纬度</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "level",
            "description": "<p>等级</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "adminCode",
            "description": "<p>行政区域编码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"companyName\": \"好想来餐饮\",\n    \"businessLicense\": \"12435980622\",\n    \"legalRepresentative\": \"赵\",\n    \"phone\": \"18630992352\",\n    \"address\": \"广东省汕头市\",\n    \"lngAndLat\": \"(113.23, 23.16)\",\n    \"level\": \"第一等级\",\n    \"adminCode\": \"440101\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-成功；2003-生成数据失败；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>餐饮企业公司ID（唯一识别）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"创建成功\",\n    \"data\": {\n        \"companyId\": 4,\n        \"memberId\": null,\n        \"companyCode\": null,\n        \"companyName\": \"好想来餐饮\",\n        \"businessLicense\": \"12435980622\",\n        \"legalRepresentative\": \"赵\",\n        \"phone\": \"18630992352\",\n        \"address\": \"广东省汕头市\",\n        \"lngandlat\": \"(113.23, 23.16)\",\n        \"isDeleted\": null,\n        \"insertTime\": null,\n        \"updateTime\": \"2021-04-05 19:54:27\",\n        \"level\": \"第一等级\",\n        \"isRecommend\": null,\n        \"adminCode\": \"440101\",\n        \"currentMaintenceBatch\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2003,\n\t\"Message\": \"生成数据失败\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/FoodCompanyController.java",
    "groupTitle": "Basic_data-餐饮企业",
    "name": "PostAddFoodCompany",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/add/food/company"
      }
    ]
  },
  {
    "type": "post",
    "url": "/delete/food/company?companyId=1",
    "title": "删除餐饮企业信息",
    "version": "0.0.1",
    "description": "<p>基础数据之删除餐饮企业信息的接口。</p>",
    "group": "Basic_data-餐饮企业",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>餐饮企业ID（唯一识别）</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-删除成功；1201-请求条件中，缺少ID参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"删除成功\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\",\n\t   \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/FoodCompanyController.java",
    "groupTitle": "Basic_data-餐饮企业",
    "name": "PostDeleteFoodCompanyCompanyid1",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/delete/food/company?companyId=1"
      }
    ]
  },
  {
    "type": "post",
    "url": "/update/food/company",
    "title": "更新餐饮企业信息",
    "version": "0.0.1",
    "description": "<p>基础数据之更新餐饮企业信息的接口。</p>",
    "group": "Basic_data-餐饮企业",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>餐饮企业ID（唯一识别，必填）</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "companyName",
            "description": "<p>餐饮企业名称</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "businessLicense",
            "description": "<p>营业执照</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "legalRepresentative",
            "description": "<p>法人代表</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>联系电话</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>地址</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "lngAndLat",
            "description": "<p>经纬度</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "level",
            "description": "<p>等级</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "adminCode",
            "description": "<p>行政区域编码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"companyId\": 4,\n    \"companyName\": \"好想来餐饮吃饭\",\n    \"businessLicense\": \"12435980622\",\n    \"legalRepresentative\": \"赵\",\n    \"phone\": \"18630992352\",\n    \"address\": \"广东省汕头市\",\n    \"lngAndLat\": \"(113.23, 23.16)\",\n    \"level\": \"第一等级\",\n    \"adminCode\": \"440101\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-更新成功；2003-更新失败；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"更新成功\",\n    \"data\": {\n        \"companyId\": 4,\n        \"memberId\": null,\n        \"companyCode\": null,\n        \"companyName\": \"好想来餐饮吃饭\",\n        \"businessLicense\": \"12435980622\",\n        \"legalRepresentative\": \"赵\",\n        \"phone\": \"18630992352\",\n        \"address\": \"广东省汕头市\",\n        \"lngandlat\": \"(113.23, 23.16)\",\n        \"isDeleted\": null,\n        \"insertTime\": null,\n        \"updateTime\": \"2021-04-05 19:54:27\",\n        \"level\": \"第一等级\",\n        \"isRecommend\": null,\n        \"adminCode\": \"440101\",\n        \"currentMaintenceBatch\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2003,\n\t\"Message\": \"更新失败\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/FoodCompanyController.java",
    "groupTitle": "Basic_data-餐饮企业",
    "name": "PostUpdateFoodCompany",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/update/food/company"
      }
    ]
  },
  {
    "type": "get",
    "url": "/payment/obtain/openid?appletsType=repast&js_code=JSCODE&grant_type=authorization_code",
    "title": "获取用户标识openid",
    "version": "0.0.1",
    "description": "<p>主要获取用户在商户appid下的唯一标识openid。</p>",
    "group": "Common-用户",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "string",
            "optional": false,
            "field": "appletsType",
            "description": "<p>用来区分获取哪个小程序的相关信息，必填，取值为：餐饮企业小程序：repast；运维小程序：operation；维保小程序：maintenance</p>"
          },
          {
            "group": "入参",
            "type": "string",
            "optional": false,
            "field": "js_code",
            "description": "<p>登录时获取的 code</p>"
          },
          {
            "group": "入参",
            "type": "string",
            "optional": false,
            "field": "grant_type",
            "description": "<p>授权类型，此处只需填写 authorization_code</p>"
          }
        ]
      }
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/MiniProgramPaymentController.java",
    "groupTitle": "Common-用户",
    "name": "GetPaymentObtainOpenidAppletstypeRepastJs_codeJscodeGrant_typeAuthorization_code",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/payment/obtain/openid?appletsType=repast&js_code=JSCODE&grant_type=authorization_code"
      }
    ]
  },
  {
    "type": "get",
    "url": "/user/overage/select?openid=oBtC65KeWP0E_FFe8trbI3RuBJ0A",
    "title": "查询充值余额",
    "version": "0.0.1",
    "description": "<p>查询充值余额。</p>",
    "group": "Common-用户",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "openid",
            "description": "<p>用户唯一标识</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-查询余额成功；2001-无此用户，查询失败；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"money\": 299.91,\n        \"openid\": \"oBtC65KeWP0E_FFe8trbI3RuBJ0A\"\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"无此用户，查询失败\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/UserController.java",
    "groupTitle": "Common-用户",
    "name": "GetUserOverageSelectOpenidObtc65kewp0e_ffe8trbi3rubj0a",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/user/overage/select?openid=oBtC65KeWP0E_FFe8trbI3RuBJ0A"
      }
    ]
  },
  {
    "type": "get",
    "url": "/user/serviceFee/calculation",
    "title": "平台服务扣费",
    "version": "0.0.1",
    "description": "<p>每天上午9点系统后台自动从用户充值余额扣除当天平台服务费，非会员服务费：一天一元，会员服务费：年费/本年天数，会员可分种类。扣费信息有日志记录。</p>",
    "group": "Common-用户",
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/UserController.java",
    "groupTitle": "Common-用户",
    "name": "GetUserServicefeeCalculation",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/user/serviceFee/calculation"
      }
    ]
  },
  {
    "type": "post",
    "url": "/user/login",
    "title": "用户登录",
    "version": "0.0.1",
    "description": "<p>用户登录接口，通过公司ID和员工号校验</p>",
    "group": "Common-用户",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>公司ID，必填。</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "userName",
            "description": "<p>工号，必填，公司+工号要确保唯一性。</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "openid",
            "description": "<p>用户唯一标识，必填。</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>手机号</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"companyId\": 1,\n    \"userName\": \"admin\",\n    \"phone\": 15894568909,\n    \"openid\": \"\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-新增设备成功；1201-请求条件中，缺少必填参数；2001-无此用户，验证失败；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"Message\": \"验证成功\",\n    \"Code\": 200\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"无此用户，验证失败\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/UserController.java",
    "groupTitle": "Common-用户",
    "name": "PostUserLogin",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/user/login"
      }
    ]
  },
  {
    "type": "post",
    "url": "/user/recharge",
    "title": "用户充值",
    "version": "0.0.1",
    "description": "<p>用户充值支付成功之后，调用这个接口。</p>",
    "group": "Common-用户",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "openid",
            "description": "<p>用户唯一标识</p>"
          },
          {
            "group": "入参",
            "type": "double",
            "optional": false,
            "field": "money",
            "description": "<p>金额</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"openid\": \"oBtC65KeWP0E_FFe8trbI3RuBJ0A\",\n    \"money\": 100.01\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-充值成功；1201-请求条件中，缺少必填参数；2001-无此用户，充值失败；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"Message\": \"充值成功\",\n    \"Code\": 200\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"无此用户，充值失败\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/UserController.java",
    "groupTitle": "Common-用户",
    "name": "PostUserRecharge",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/user/recharge"
      }
    ]
  },
  {
    "type": "get",
    "url": "/news/list?companyId=1&companyType=repast",
    "title": "获取消息",
    "version": "0.0.1",
    "description": "<p>获取某企业/公司的所有消息。</p>",
    "group": "Common-获取消息",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>公司ID，取值是系统生成的，必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "companyType",
            "description": "<p>公司类型，必填，取值为：餐饮：repast；运维：operation；维保：maintenance</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-消息更新成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "newsList",
            "description": "<p>消息列表</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"获取消息成功\",\n    \"data\": {\n        \"newsList\": [\n            {\n                \"id\": 4,\n                \"articleTypeCode\": \"message\",\n                \"articleTypeName\": \"消息\",\n                \"title\": \"关于食在不一样餐饮企业欠费通知\",\n                \"content\": \"关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知\",\n                \"releaseTime\": \"2021-07-25T12:21:38.000+0000\",\n                \"issuer\": \"李思琪\",\n                \"playCount\": 23,\n                \"isRecommend\": true,\n                \"createTime\": \"2021-07-12T09:31:55.000+0000\",\n                \"modifiedTime\": \"2021-07-12T09:31:55.000+0000\",\n                \"isDeleted\": false,\n                \"isEnable\": true,\n                \"typeId\": null,\n                \"adminCode\": \"\",\n                \"moduleCode\": \"food_company\",\n                \"moduleId\": 1\n            },\n            {\n                \"id\": 5,\n                \"articleTypeCode\": \"message\",\n                \"articleTypeName\": \"消息\",\n                \"title\": \"怪味青年螺蛳粉设备连续预警7天\",\n                \"content\": \"怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天\",\n                \"releaseTime\": \"2021-07-25T12:30:18.000+0000\",\n                \"issuer\": \"黄铭\",\n                \"playCount\": 34,\n                \"isRecommend\": true,\n                \"createTime\": \"2021-07-12T09:31:55.000+0000\",\n                \"modifiedTime\": \"2021-07-12T09:31:55.000+0000\",\n                \"isDeleted\": false,\n                \"isEnable\": true,\n                \"typeId\": null,\n                \"adminCode\": \"\",\n                \"moduleCode\": \"food_company\",\n                \"moduleId\": 1\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\"Code\": \"2001\",\n\"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/NewsPushController.java",
    "groupTitle": "Common-获取消息",
    "name": "GetNewsListCompanyid1CompanytypeRepast",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/news/list?companyId=1&companyType=repast"
      }
    ]
  },
  {
    "type": "get",
    "url": "/order/dispatch/track?orderNumber=161804062344690",
    "title": "追踪订单的派单信息",
    "version": "0.0.1",
    "description": "<p>根据订单号查询出该订单派给了谁。</p>",
    "group": "Common-订单",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "orderNumber",
            "description": "<p>订单号</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "data",
            "description": "<p>结果集</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "devices",
            "description": "<p>设备</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "processorIdArray",
            "description": "<p>派单员工</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "dispatchTime",
            "description": "<p>派单时间</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "updateDispatchTime",
            "description": "<p>修改派单信息时间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"maintenanceId\": null,\n        \"maintenanceCompanyId\": null,\n        \"isDeleted\": null,\n        \"insertTime\": null,\n        \"updateTime\": null,\n        \"orderTypeCode\": null,\n        \"foodCompanyId\": null,\n        \"processorId\": null,\n        \"money\": 90.5,\n        \"orderStatus\": 4,\n        \"genType\": null,\n        \"batch\": null,\n        \"time\": \"2021-04-19\",\n        \"maintenancePeriod\": 2,\n        \"remark\": \"设备安装\",\n        \"warnId\": null,\n        \"orderNumber\": \"161804062344690\",\n        \"flowNum\": \"3121null\",\n        \"devices\": {\n            \"normal\": [\n                {\n                    \"deviceId\": \"123456\"\n                },\n                {\n                    \"deviceId\": \"123457\"\n                },\n                {\n                    \"deviceId\": \"123458\"\n                }\n            ],\n            \"earlyWarning\": [\n                {\n                    \"deviceId\": \"123459\"\n                }\n            ],\n            \"alarm\": []\n        },\n        \"insertTimeStart\": null,\n        \"insertTimeEnd\": null,\n        \"pageNumber\": 0,\n        \"outSelectSerial\": 0,\n        \"selectFlag\": null,\n        \"companyName\": \"好想来餐饮\",\n        \"phone\": \"18630992352\",\n        \"address\": \"广东省汕头市\",\n        \"processorIdArray\": [\n            {\n                \"processorId\": 1\n            },\n            {\n                \"processorId\": 2\n            }\n        ],\n        \"dispatchTime\": \"2021-04-19 18:57:04\",\n        \"clientEstimate\": 1,\n        \"signImg\": \"xxx\",\n        \"missionImg\": \"yyy\",\n        \"acceptanceTime\": \"2021-04-19 18:58:27\",\n        \"updateDispatchTime\": \"2021-04-20 22:44:00\"\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OrderController.java",
    "groupTitle": "Common-订单",
    "name": "GetOrderDispatchTrackOrdernumber161804062344690",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/order/dispatch/track?orderNumber=161804062344690"
      }
    ]
  },
  {
    "type": "post",
    "url": "/order/dispatch/select",
    "title": "派单查询",
    "version": "0.0.1",
    "description": "<p>根据员工号或订单状态查询该员工的派单信息。</p>",
    "group": "Common-订单",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "processorId",
            "description": "<p>派单员工工号，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "orderStatus",
            "description": "<p>订单状态（4：待处理（等待员工处理）  5、已完成（含餐饮签名的照片上传）），若查询全部-值为null。</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"processorId\": 1111,\n    \"orderStatus\": 3\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "data",
            "description": "<p>结果集</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "devices",
            "description": "<p>设备</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "processorIdArray",
            "description": "<p>派单员工</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "dispatchTime",
            "description": "<p>派单时间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": [\n        {\n            \"money\": 90.5,\n            \"orderStatus\": 3,\n            \"time\": \"2021-06-19\",\n            \"maintenancePeriod\": 2,\n            \"remark\": \"电话联系\",\n            \"orderNumber\": \"161797298403681\",\n            \"flowNum\": \"1121null\",\n            \"devices\": {\n                \"normal\": [\n                    {\n                        \"deviceId\": \"123456\"\n                    },\n                    {\n                        \"deviceId\": \"123457\"\n                    },\n                    {\n                        \"deviceId\": \"123458\"\n                    }\n                ],\n                \"earlyWarning\": [\n                    {\n                        \"deviceId\": \"123450\"\n                    }\n                ],\n                \"alarm\": []\n            },\n            \"companyName\": \"好吃餐饮\",\n            \"phone\": \"18630992352\",\n            \"address\": \"广东省汕头市\",\n            \"processorIdArray\": [\n                {\n                    \"processorId\": 1111\n                },\n                {\n                    \"processorId\": 1112\n                }\n            ],\n            \"dispatchTime\": \"2021-04-16 11:35:38\"\n        },\n        {\n            \"money\": 90.5,\n            \"orderStatus\": 3,\n            \"time\": \"2021-04-19\",\n            \"maintenancePeriod\": 2,\n            \"remark\": \"设备安装\",\n            \"orderNumber\": \"161804062344690\",\n            \"flowNum\": \"3121null\",\n            \"devices\": {\n                \"normal\": [\n                    {\n                        \"deviceId\": \"123456\"\n                    },\n                    {\n                        \"deviceId\": \"123457\"\n                    },\n                    {\n                        \"deviceId\": \"123458\"\n                    }\n                ],\n                \"earlyWarning\": [\n                    {\n                        \"deviceId\": \"123459\"\n                    }\n                ],\n                \"alarm\": []\n            },\n            \"companyName\": \"好想来餐饮\",\n            \"phone\": \"18630992352\",\n            \"address\": \"广东省汕头市\",\n            \"processorIdArray\": [\n                {\n                    \"processorId\": 1111\n                },\n                {\n                    \"processorId\": 1112\n                }\n            ],\n            \"dispatchTime\": \"2021-04-16 11:35:38\"\n        }\n    ]\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OrderController.java",
    "groupTitle": "Common-订单",
    "name": "PostOrderDispatchSelect",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/order/dispatch/select"
      }
    ]
  },
  {
    "type": "post",
    "url": "/order/dispatch/staff",
    "title": "派单给员工",
    "version": "0.0.1",
    "description": "<p>支持运维/维保公司派单给多位员工而修改订单的派单人员信息的接口说明。</p>",
    "group": "Common-订单",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "orderNumber",
            "description": "<p>订单编号，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "orderStatus",
            "description": "<p>订单状态 (1：已分配（已分配到公司） 2:待确认（等待餐饮企业确认订单） 3：待派单（等待公司派单到员工）  4：待处理（等待员工处理）  5、已完成（含餐饮签名的照片上传）），必填</p>"
          },
          {
            "group": "入参",
            "type": "array",
            "optional": false,
            "field": "processorIdArray",
            "description": "<p>派单员工工号数组，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "processorId",
            "description": "<p>派单员工工号（至少一位）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"orderNumber\": \"161797298403681\",\n    \"orderStatus\": 3,\n    \"processorIdArray\": [\n        {\n            \"processorId\": 1111\n        },\n        {\n            \"processorId\": 1112\n        }\n    ]\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-派单成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"派单成功\"\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OrderController.java",
    "groupTitle": "Common-订单",
    "name": "PostOrderDispatchStaff",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/order/dispatch/staff"
      }
    ]
  },
  {
    "type": "post",
    "url": "/order/dispatch/update",
    "title": "修改/取消派单",
    "version": "0.0.1",
    "description": "<p>支持运维/维保公司修改/取消派单信息的接口说明。</p>",
    "group": "Common-订单",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "orderNumber",
            "description": "<p>订单编号，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "orderStatus",
            "description": "<p>订单状态 (1：已分配（已分配到公司） 2:待确认（等待餐饮企业确认订单） 3：待派单（等待公司派单到员工）  4：待处理（等待员工处理）  5、已完成（含餐饮签名的照片上传）），必填</p>"
          },
          {
            "group": "入参",
            "type": "array",
            "optional": false,
            "field": "processorIdArray",
            "description": "<p>派单员工工号数组，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "processorId",
            "description": "<p>派单员工工号，若修改派单信息，员工号至少有一个，状态值为4；若取消派单，则传一个空processorIdArray，状态值为3。</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"orderNumber\": \"161797298403681\",\n    \"orderStatus\": 3,\n    \"processorIdArray\": [\n\n    ]\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-修改派单信息成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"修改派单信息成功\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OrderController.java",
    "groupTitle": "Common-订单",
    "name": "PostOrderDispatchUpdate",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/order/dispatch/update"
      }
    ]
  },
  {
    "type": "post",
    "url": "/order/weChat/uploadImage",
    "title": "上传图片",
    "version": "0.0.1",
    "description": "<p>上传签名照和取证照片的接口说明。</p>",
    "group": "Common-订单",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "signImgFile",
            "description": "<p>签名照key，必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "missionImgFile",
            "description": "<p>拍照key，必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "orderNumber",
            "description": "<p>订单编号，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "orderStatus",
            "description": "<p>订单状态 (1：已分配（已分配到公司） 2:待确认（等待餐饮企业确认订单） 3：待派单（等待公司派单到员工）  4：待处理（等待员工处理）  5、已完成（含餐饮签名的照片上传）），必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "orderType",
            "description": "<p>订单类型(设备清洗、设备维修、设备安装)，必填</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-url；2001-上传失败；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "acceptanceTime",
            "description": "<p>上传时间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"data\": \"http://106.15.73.226/acc-image/2021042223354757.jpg\",\n    \"statusCode\": 200\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": \"2001\",\n\t   \"Message\": \"上传失败\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OrderController.java",
    "groupTitle": "Common-订单",
    "name": "PostOrderWechatUploadimage",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/order/weChat/uploadImage"
      }
    ]
  },
  {
    "type": "get",
    "url": "/assess/food/select?userId=4543565",
    "title": "评价查询",
    "version": "0.0.1",
    "description": "<p>根据用户ID查询该用户对订单的评价。</p>",
    "group": "Common-评价",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID，必填</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "commentTime",
            "description": "<p>评论时间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": [\n        {\n            \"id\": 1,\n            \"moduleId\": null,\n            \"module\": null,\n            \"userId\": \"4543565\",\n            \"orderNumber\": \"161797298403681\",\n            \"content\": \"很好！\",\n            \"commentTime\": \"2021-04-28 13:49:32.0\",\n            \"isDeleted\": false,\n            \"clientEstimate\": 3.5\n        },\n        {\n            \"id\": 2,\n            \"moduleId\": null,\n            \"module\": null,\n            \"userId\": \"4543565\",\n            \"orderNumber\": \"161820642138668\",\n            \"content\": \"很棒！\",\n            \"commentTime\": \"2021-04-28 15:14:01.0\",\n            \"isDeleted\": false,\n            \"clientEstimate\": 4.0\n        }\n    ]\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/CommentController.java",
    "groupTitle": "Common-评价",
    "name": "GetAssessFoodSelectUserid4543565",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/assess/food/select?userId=4543565"
      }
    ]
  },
  {
    "type": "post",
    "url": "/assess/food/insert",
    "title": "餐饮企业评价",
    "version": "0.0.1",
    "description": "<p>餐饮企业员工对运维/维保公司员工完成的订单进行评价。</p>",
    "group": "Common-评价",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID，必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "orderNumber",
            "description": "<p>订单编号，必填</p>"
          },
          {
            "group": "入参",
            "type": "double",
            "optional": false,
            "field": "clientEstimate",
            "description": "<p>客户满意度（5星制：1-5），必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "content",
            "description": "<p>评价内容（不超255字节）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "\n{\n    \"orderNumber\": \"161797298403681\",\n    \"userId\": 4543565,\n    \"clientEstimate\": 3.5,\n    \"content\": \"很好！\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-评价成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "acceptanceTime",
            "description": "<p>上传时间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"上传成功\",\n    \"data\": {\n        \"orderStatus\": 4,\n        \"orderNumber\": \"161797298403681\",\n        \"clientEstimate\": 1,\n        \"signImg\": \"xxx\",\n        \"missionImg\": \"yyy\",\n        \"acceptanceTime\": \"2021-04-16 13:39:10\"\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/CommentController.java",
    "groupTitle": "Common-评价",
    "name": "PostAssessFoodInsert",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/assess/food/insert"
      }
    ]
  },
  {
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "optional": false,
            "field": "varname1",
            "description": "<p>No type.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "varname2",
            "description": "<p>With type.</p>"
          }
        ]
      }
    },
    "type": "",
    "url": "",
    "version": "0.0.0",
    "filename": "server/apidoc/main.js",
    "group": "E:\\project-java\\server\\server\\apidoc\\main.js",
    "groupTitle": "E:\\project-java\\server\\server\\apidoc\\main.js",
    "name": ""
  },
  {
    "type": "get",
    "url": "/payment/access/token?appletsType=repast&grant_type=client_credential",
    "title": "获取token",
    "version": "0.0.1",
    "description": "<p>获取小程序全局唯一后台接口调用凭据（access_token）。</p>",
    "group": "MiniProgram-支付",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "string",
            "optional": false,
            "field": "appletsType",
            "description": "<p>用来区分获取哪个小程序的相关信息，必填，取值为：餐饮企业小程序：repast；运维小程序：operation；维保小程序：maintenance</p>"
          },
          {
            "group": "入参",
            "type": "string",
            "optional": false,
            "field": "grant_type",
            "description": "<p>填写 client_credential，必填</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "string",
            "optional": false,
            "field": "access_token",
            "description": "<p>获取到的凭证</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "expires_in",
            "description": "<p>凭证有效时间，单位：秒。目前是7200秒之内的值。</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "errcode",
            "description": "<p>的合法值：-1\t系统繁忙，此时请开发者稍候再试；0\t请求成功；40001\tAppSecret 错误或者 AppSecret 不属于这个小程序，请开发者确认 AppSecret 的正确性；40002\t请确保 grant_type 字段值为 client_credential；40013\t不合法的 AppID，请开发者检查 AppID 的正确性，避免异常字符，注意大小写。</p>"
          },
          {
            "group": "出参",
            "type": "string",
            "optional": false,
            "field": "errmsg",
            "description": "<p>错误信息</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"access_token\": \"44_cSxcYHErmAJT3SBdDer_fOR8ErQPAhxFds_PNtmfLHQXBCeberYn-vWKExfDh7fsOXPOcME34eSn40f3z4xxx_l5MN3SBSMMwL_3fSCvJNaE1c66U-HHby_rnHka8Qo-oHBTJGGba46qu0fbOKQbAGAVRX\",\n    \"expires_in\": 7200\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"errcode\": 40013,\n    \"errmsg\": \"invalid appid rid: 608b6fb5-64fd614c-0ed57e11\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/MiniProgramPaymentController.java",
    "groupTitle": "MiniProgram-支付",
    "name": "GetPaymentAccessTokenAppletstypeRepastGrant_typeClient_credential",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/payment/access/token?appletsType=repast&grant_type=client_credential"
      }
    ]
  },
  {
    "type": "get",
    "url": "/payment/status/select?mchid=1608995427&out_trade_no=161944758928971",
    "title": "支付状态查询",
    "version": "0.0.1",
    "description": "<p>商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。查询订单状态可通过微信支付订单号或商户订单号两种方式查询，这里通过商户订单号查询。</p>",
    "group": "MiniProgram-支付",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "string",
            "optional": false,
            "field": "mchid",
            "description": "<p>直连商户号，必填</p>"
          },
          {
            "group": "入参",
            "type": "string",
            "optional": false,
            "field": "out_trade_no",
            "description": "<p>商户订单号，必填</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n\t\"amount\": {\n\t\t\"currency\": \"CNY\",\n\t\t\"payer_currency\": \"CNY\",\n\t\t\"payer_total\": 1,\n\t\t\"total\": 1\n       },\n\t\"appid\": \"wxdace645e0bc2cXXX\",\n\t\"attach\": \"\",\n\t\"bank_type\": \"OTHERS\",\n\t\"mchid\": \"1900006XXX\",\n\t\"out_trade_no\": \"44_2126281063_5504\",\n\t\"payer\": {\n\t\t\"openid\": \"o4GgauJP_mgWEWictzA15WT15XXX\"\n   },\n\t\"promotion_detail\": [],\n\t\"success_time\": \"2021-03-22T10:29:05+08:00\",\n\t\"trade_state\": \"SUCCESS\",\n\t\"trade_state_desc\": \"支付成功\",\n\t\"trade_type\": \"JSAPI\",\n\t\"transaction_id\": \"4200000891202103228088184743\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/MiniProgramPaymentController.java",
    "groupTitle": "MiniProgram-支付",
    "name": "GetPaymentStatusSelectMchid1608995427Out_trade_no161944758928971",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/payment/status/select?mchid=1608995427&out_trade_no=161944758928971"
      }
    ]
  },
  {
    "type": "post",
    "url": "/payment/prepaid/order",
    "title": "生成预付单",
    "version": "0.0.1",
    "description": "<p>在微信小程序对订单进行下单，发起支付，生成预付单（1-6）。</p>",
    "group": "MiniProgram-支付",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "string",
            "optional": false,
            "field": "out_trade_no",
            "description": "<p>订单号，必填</p>"
          },
          {
            "group": "入参",
            "type": "string",
            "optional": false,
            "field": "description",
            "description": "<p>商品描述，Image形象店-深圳腾大-QQ公仔，必填</p>"
          },
          {
            "group": "入参",
            "type": "object",
            "optional": false,
            "field": "payer",
            "description": "<p>支付者，必填</p>"
          },
          {
            "group": "入参",
            "type": "string",
            "optional": false,
            "field": "openid",
            "description": "<p>用户标识，父级payer，必填</p>"
          },
          {
            "group": "入参",
            "type": "object",
            "optional": false,
            "field": "amount",
            "description": "<p>订单金额，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "total",
            "description": "<p>订单总金额，单位为分，父级amount，必填</p>"
          },
          {
            "group": "入参",
            "type": "object",
            "optional": false,
            "field": "currency",
            "description": "<p>货币类型，CNY：人民币，境内商户号仅支持人民币，父级amount。</p>"
          },
          {
            "group": "入参",
            "type": "string",
            "optional": false,
            "field": "appletsType",
            "description": "<p>用来区分获取哪个小程序的相关信息，必填，餐饮企业为：repast。</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"out_trade_no\": \"1217752501201407033233368318\",\n    \"description\": \"Image形象店-深圳腾大-QQ公仔\",\n    \"amount\": {\n        \"total\": 1,\n        \"currency\": \"CNY\"\n    },\n    \"payer\": {\n        \"openid\": \"oBtC65KeWP0E_FFe8trbI3RuBJ0A\"\n    },\n    \"appletsType\": \"repast\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "string",
            "optional": false,
            "field": "prepay_id",
            "description": "<p>预支付交易会话标识，预支付交易会话标识。用于后续接口调用中使用，该值有效期为2小时</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"timeStamp\": 1620805873,\n    \"paySign\": \"JkRR5QCDk0rOlbhcwoGnUtXo+Ae7j5Xc0INgldLanAR76QUQghoKehbmSDheqKXaPU7nKkJE/E3d7QzkAG56L8T2TBwpWF3PYw8onIIXEtdJYCYAvECl9glQ5LJd4OArk4fOKCi5RUIoM2mjYM5KyQI7TkXPiQho3qGueitdCwezHMAFHUnazCpJU6jyjWcdZ2Zp5XD8aQ2hS5CecVFDkAVCRtju3d6dqoiJfvWnNtNObP9Z+zaykLFTTjPvk9dDQDs+SSzEJNJX7JFire8qwroAduuOQjltndTySRiOyJ1VTokU9W174j7a9Y/0wLOIxGC52OoEK7kyJXWGIDz9zw==\",\n    \"appid\": \"wxc2c2d16a2d9ab49d\",\n    \"nonceStr\": \"M4vmagsg8WN2C9x5Oktk5XwzUaH50aMW\",\n    \"prepay_id\": \"wx1215511458536182505793acb197ac0000\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/MiniProgramPaymentController.java",
    "groupTitle": "MiniProgram-支付",
    "name": "PostPaymentPrepaidOrder",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/payment/prepaid/order"
      }
    ]
  },
  {
    "type": "post",
    "url": "/payment/receive/notification",
    "title": "接收通知（微信支付系统调用）",
    "version": "0.0.1",
    "description": "<p>微信支付通过支付通知接口将用户支付成功消息通知给商户。</p>",
    "group": "MiniProgram-支付",
    "parameter": {
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"id\":\"EV-2018022511223320873\",\n    \"create_time\":\"2015-05-20T13:29:35+08:00\",\n    \"resource_type\":\"encrypt-resource\",\n    \"event_type\":\"TRANSACTION.SUCCESS\",\n    \"resource\":{\n        \"algorithm\":\"AEAD_AES_256_GCM\",\n        \"ciphertext\":\"...\",\n        \"nonce\":\"...\",\n        \"original_type\":\"transaction\",\n        \"associated_data\":\"\"\n    },\n    \"summary\":\"支付成功\"\n}",
          "type": "json"
        },
        {
          "title": "解密参数：",
          "content": "{\n    \"mchid\": \"1608995427\",\n    \"appid\": \"wxc2c2d16a2d9ab49d\",\n    \"out_trade_no\": \"162090628514989\",\n    \"transaction_id\": \"4200001043202105133398534300\",\n    \"trade_type\": \"JSAPI\",\n    \"trade_state\": \"SUCCESS\",\n    \"trade_state_desc\": \"支付成功\",\n    \"bank_type\": \"OTHERS\",\n    \"attach\": \"\",\n    \"success_time\": \"2021-05-13T19:46:36+08:00\",\n    \"payer\": {\n        \"openid\": \"oBtC65KeWP0E_FFe8trbI3RuBJ0A\"\n    },\n    \"amount\": {\n        \"total\": 1,\n        \"payer_total\": 1,\n        \"currency\": \"CNY\",\n        \"payer_currency\": \"CNY\"\n    }\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": \"SUCCESS\",\n    \"message\": \"成功\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/MiniProgramPaymentController.java",
    "groupTitle": "MiniProgram-支付",
    "name": "PostPaymentReceiveNotification",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/payment/receive/notification"
      }
    ]
  },
  {
    "type": "get",
    "url": "/authority/all/select",
    "title": "查询所有权限信息",
    "version": "0.0.1",
    "description": "<p>运维端管理系统-权限管理-查询所有权限信息接口说明，没有入参。</p>",
    "group": "operation-权限管理",
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-设备查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "deviceId",
            "description": "<p>设备编号</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "authorityList",
            "description": "<p>查询结果集</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"authorityList\": [\n            {\n                \"authorityId\": 2,\n                \"userType\": \"运维公司\",\n                \"authorityName\": \"删\",\n                \"authorityCode\": \"delect\",\n                \"createTime\": \"2021-04-10 22:24:52.0\",\n                \"modifiedTime\": null,\n                \"isDeleted\": false\n            },\n            {\n                \"authorityId\": 3,\n                \"userType\": \"运维公司\",\n                \"authorityName\": \"改\",\n                \"authorityCode\": \"update\",\n                \"createTime\": \"2021-04-10 22:25:10.0\",\n                \"modifiedTime\": null,\n                \"isDeleted\": false\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/AuthorityController.java",
    "groupTitle": "operation-权限管理",
    "name": "GetAuthorityAllSelect",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/authority/all/select"
      }
    ]
  },
  {
    "type": "get",
    "url": "/authority/delete?authorityId=1",
    "title": "删除权限",
    "version": "0.0.1",
    "description": "<p>运维端管理系统-权限管理-删除权限接口说明。</p>",
    "group": "operation-权限管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "authorityId",
            "description": "<p>权限ID（唯一识别），必填。</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-删除成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"删除成功\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/AuthorityController.java",
    "groupTitle": "operation-权限管理",
    "name": "GetAuthorityDeleteAuthorityid1",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/authority/delete?authorityId=1"
      }
    ]
  },
  {
    "type": "get",
    "url": "/authority/userType/select?userType=运维公司",
    "title": "查询权限",
    "version": "0.0.1",
    "description": "<p>运维端管理系统-权限管理-查询权限接口说明，以用户类型为单位进行查询。</p>",
    "group": "operation-权限管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "userType",
            "description": "<p>用户类型（运维公司、餐饮企业、监管部门、维保公司）。</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-设备查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "deviceId",
            "description": "<p>设备编号</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "authorityNameList",
            "description": "<p>查询结果集</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "authority_name",
            "description": "<p>权限名称</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"authorityNameList\": [\n            {\n                \"authority_name\": \"删\"\n            },\n            {\n                \"authority_name\": \"改\"\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/AuthorityController.java",
    "groupTitle": "operation-权限管理",
    "name": "GetAuthorityUsertypeSelectUsertype",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/authority/userType/select?userType=运维公司"
      }
    ]
  },
  {
    "type": "post",
    "url": "/authority/add",
    "title": "新增权限",
    "version": "0.0.1",
    "description": "<p>运维端管理系统-权限管理-新增权限接口说明。</p>",
    "group": "operation-权限管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "userType",
            "description": "<p>用户类型（运维公司、餐饮企业、监管部门、维保公司）。</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "authorityName",
            "description": "<p>权限名称（增、删、改、查）</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "authorityCode",
            "description": "<p>权限编码（add、delete、update、select）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"userType\": \"运维\",\n    \"authorityName\": \"增\",\n    \"authorityCode\": \"add\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-新增成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "authorityId",
            "description": "<p>权限ID（唯一识别，系统生成）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"新增成功\",\n    \"data\": {\n        \"authorityId\": 1,\n        \"userType\": \"运维\",\n        \"authorityName\": \"增\",\n        \"authorityCode\": \"add\",\n        \"createTime\": \"2021-04-10 21:48:27\",\n        \"modifiedTime\": null,\n        \"isDeleted\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/AuthorityController.java",
    "groupTitle": "operation-权限管理",
    "name": "PostAuthorityAdd",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/authority/add"
      }
    ]
  },
  {
    "type": "post",
    "url": "/authority/update",
    "title": "修改权限",
    "version": "0.0.1",
    "description": "<p>运维端管理系统-权限管理-修改权限接口说明。</p>",
    "group": "operation-权限管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "authority_id",
            "description": "<p>权限ID（唯一识别），不可修改，必填。</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "userType",
            "description": "<p>用户类型（运维公司、餐饮企业、监管部门、维保公司）。</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "authorityName",
            "description": "<p>权限名称（增、删、改、查）</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "authorityCode",
            "description": "<p>权限编码（add、delete、update、select）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"authorityId\": 1\n    \"userType\": \"运维公司\",\n    \"authorityName\": \"增\",\n    \"authorityCode\": \"add\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-修改成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"更新成功\",\n    \"data\": {\n        \"authorityId\": 1,\n        \"userType\": \"运维公司\",\n        \"authorityName\": \"增\",\n        \"authorityCode\": \"add\",\n        \"createTime\": \"2021-04-10 21:48:27.0\",\n        \"modifiedTime\": \"2021-04-10 22:06:05.0\",\n        \"isDeleted\": false\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/AuthorityController.java",
    "groupTitle": "operation-权限管理",
    "name": "PostAuthorityUpdate",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/authority/update"
      }
    ]
  },
  {
    "type": "get",
    "url": "/order/auto/generated",
    "title": "自动生成订单",
    "version": "0.0.1",
    "description": "<p>针对预警/报警设备进行设备清洗，假定运维端系统每天凌晨4点自动生成餐饮企业的设备清洗订单。</p>",
    "group": "operation-订单管理",
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-2021-04-20 18:39:12 自动生成订单成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "data",
            "description": "<p>各餐饮企业可能产生的订单的数组</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"2021-07-14 21:55:16 自动生成订单成功\",\n    \"data\": [\n        {\n            \"maintenanceId\": 42,\n            \"maintenanceCompanyId\": 4,\n            \"isDeleted\": false,\n            \"insertTime\": \"2021-07-14 21:36:56.0\",\n            \"updateTime\": \"2021-07-14 21:55:17.0\",\n            \"orderType\": \"wash\",\n            \"foodCompanyId\": 1,\n            \"oneProcessorId\": null,\n            \"processorId\": null,\n            \"money\": 100.0,\n            \"orderStatus\": 2,\n            \"genType\": \"系统修改生成\",\n            \"batch\": null,\n            \"time\": \"2021-07-14 21:36:52.0\",\n            \"maintenanceTimeseg\": null,\n            \"remark\": null,\n            \"warnId\": null,\n            \"orderNumber\": \"162626981704642\",\n            \"flowNum\": null,\n            \"devices\": {\n                \"normal\": [],\n                \"earlyWarning\": [\n                    {\n                        \"deviceId\": \"20210533\",\n                        \"seqNum\": null,\n                        \"gateId\": null\n                    }\n                ],\n                \"alarm\": [\n                    {\n                        \"deviceId\": \"20210532\",\n                        \"seqNum\": null,\n                        \"gateId\": null\n                    }\n                ]\n            },\n            \"insertTimeStart\": null,\n            \"insertTimeEnd\": null,\n            \"pageNumber\": 0,\n            \"outSelectSerial\": 0,\n            \"selectFlag\": null,\n            \"companyName\": \"六三好食在·柴火妈妈饭\",\n            \"phone\": \"15078327874\",\n            \"address\": \"广西壮族自治区桂林市七星区空明西路27号\",\n            \"processorIdArray\": null,\n            \"dispatchTime\": null,\n            \"clientEstimate\": null,\n            \"signImg\": null,\n            \"missionImg\": null,\n            \"acceptanceTime\": null,\n            \"updateDispatchTime\": null\n        },\n        {\n            \"maintenanceId\": 43,\n            \"maintenanceCompanyId\": 3,\n            \"isDeleted\": null,\n            \"insertTime\": \"2021-07-14 21:55:19\",\n            \"updateTime\": null,\n            \"orderType\": \"wash\",\n            \"foodCompanyId\": 2,\n            \"oneProcessorId\": 0,\n            \"processorId\": null,\n            \"money\": 20.0,\n            \"orderStatus\": 1,\n            \"genType\": \"系统生成\",\n            \"batch\": null,\n            \"time\": \"2021-07-14 21:55:16\",\n            \"maintenanceTimeseg\": null,\n            \"remark\": null,\n            \"warnId\": null,\n            \"orderNumber\": \"162627091984343\",\n            \"flowNum\": null,\n            \"devices\": {\n                \"normal\": [],\n                \"earlyWarning\": [],\n                \"alarm\": [\n                    {\n                        \"deviceId\": \"20210532\",\n                        \"seqNum\": null,\n                        \"gateId\": null\n                    }\n                ]\n            },\n            \"insertTimeStart\": null,\n            \"insertTimeEnd\": null,\n            \"pageNumber\": 0,\n            \"outSelectSerial\": 0,\n            \"selectFlag\": null,\n            \"companyName\": \"常德津市特色牛肉面馆\",\n            \"phone\": \"13132746992\",\n            \"address\": \"\",\n            \"processorIdArray\": null,\n            \"dispatchTime\": null,\n            \"clientEstimate\": null,\n            \"signImg\": null,\n            \"missionImg\": null,\n            \"acceptanceTime\": null,\n            \"updateDispatchTime\": null\n        }\n    ]\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OrderController.java",
    "groupTitle": "operation-订单管理",
    "name": "GetOrderAutoGenerated",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/order/auto/generated"
      }
    ]
  },
  {
    "type": "get",
    "url": "/order/operation/delete?orderNumber=161752709559154",
    "title": "删除订单",
    "version": "0.0.1",
    "description": "<p>本例为运维端管理系统的订单删除说明。</p>",
    "group": "operation-订单管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "orderNumber",
            "description": "<p>订单编号</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-订单删除成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"订单删除成功\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OrderController.java",
    "groupTitle": "operation-订单管理",
    "name": "GetOrderOperationDeleteOrdernumber161752709559154",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/order/operation/delete?orderNumber=161752709559154"
      }
    ]
  },
  {
    "type": "get",
    "url": "/select/status/device?status=正常&companyId=1",
    "title": "查询XX状态的设备",
    "version": "0.0.1",
    "description": "<p>运维端管理系统-餐饮企业-订单管理-新增订单-设备关联接口说明。</p>",
    "group": "operation-订单管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "status",
            "description": "<p>设备状态（正常、预警、报警）</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>订单中的餐饮企业ID（必填）</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "deviceIdList",
            "description": "<p>结果集</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "device_id",
            "description": "<p>设备ID（唯一识别）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"deviceIdList\": [\n            {\n                \"device_id\": \"20210410\"\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2001,\n\t\"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/DeviceRunparamController.java",
    "groupTitle": "operation-订单管理",
    "name": "GetSelectStatusDeviceStatusCompanyid1",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/select/status/device?status=正常&companyId=1"
      }
    ]
  },
  {
    "type": "post",
    "url": "/order/operation/add",
    "title": "新增订单",
    "version": "0.0.1",
    "description": "<p>本例为运维端管理系统的新增订单说明。</p>",
    "group": "operation-订单管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "orderType",
            "description": "<p>订单类型编码（设备清洗、设备维修、设备安装），必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "foodCompanyId",
            "description": "<p>餐饮企业ID，必填</p>"
          },
          {
            "group": "入参",
            "type": "double",
            "optional": false,
            "field": "money",
            "description": "<p>订单金额</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "time",
            "description": "<p>维保日期，必填</p>"
          },
          {
            "group": "入参",
            "type": "string",
            "optional": false,
            "field": "maintenanceTimeseg",
            "description": "<p>维保时间段（09:00-10:30  10:30-12:00  14:00-15:30 15:30-17:00），必填</p>"
          },
          {
            "group": "入参",
            "type": "string",
            "optional": false,
            "field": "genType",
            "description": "<p>订单产生方式（运维  餐饮  系统），必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "batch",
            "description": "<p>订单批次</p>"
          },
          {
            "group": "入参",
            "type": "set",
            "optional": false,
            "field": "devices",
            "description": "<p>设备关联，必填</p>"
          },
          {
            "group": "入参",
            "type": "array",
            "optional": false,
            "field": "normal",
            "description": "<p>正常设备（父级：devices）</p>"
          },
          {
            "group": "入参",
            "type": "array",
            "optional": false,
            "field": "earlyWarning",
            "description": "<p>预警设备（父级：devices）</p>"
          },
          {
            "group": "入参",
            "type": "array",
            "optional": false,
            "field": "alarm",
            "description": "<p>报警设备（父级：devices）</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "deviceId",
            "description": "<p>设备ID（父级：normal||earlyWarning||alarm）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"orderType\": \"设备清洗\",\n    \"foodCompanyId\": 1,\n    \"money\": 90.5,\n    \"time\": \"2021-04-19\",\n    \"maintenanceTimeseg\": \"09:00-10:30\",\n    \"genType\": \"运维\",\n    \"remark\": \"电话联系\",\n    \"devices\": {\n        \"normal\": [\n            {\n                \"deviceId\": \"123456\"\n            },\n            {\n                \"deviceId\": \"123457\"\n            },\n            {\n                \"deviceId\": \"123458\"\n            }\n        ],\n        \"earlyWarning\": [\n            {\n                \"deviceId\": \"123459\"\n            },\n            {\n                \"deviceId\": \"123450\"\n            }\n        ],\n        \"alarm\": [\n            {\n                \"deviceId\": \"123451\"\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-创建订单成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "maintenanceId",
            "description": "<p>订单序号</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "maintenanceCompanyId",
            "description": "<p>派单公司ID（包括运维公司、维保公司）</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "oneProcessorId",
            "description": "<p>订单在系统中生成时，系统根据算法指定的一个公司中的一位派单负责人</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "orderNumber",
            "description": "<p>订单编号</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "flowNum",
            "description": "<p>订单流水号</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"订单创建成功\",\n    \"data\": {\n        \"maintenanceId\": 17,\n        \"maintenanceCompanyId\": 4,\n        \"isDeleted\": null,\n        \"insertTime\": \"2021-06-23 20:01:14\",\n        \"updateTime\": null,\n        \"orderType\": \"设备清洗\",\n        \"foodCompanyId\": 1,\n        \"oneProcessorId\": 0,\n        \"money\": 90.5,\n        \"orderStatus\": 1,\n        \"genType\": \"运维\",\n        \"batch\": null,\n        \"time\": \"2021-04-19\",\n        \"maintenanceTimeseg\": \"09:00-10:30\",\n        \"remark\": \"电话联系\",\n        \"warnId\": null,\n        \"orderNumber\": \"162444967488817\",\n        \"flowNum\": null,\n        \"devices\": {\n            \"normal\": [\n                {\n                    \"deviceId\": \"123456\",\n                    \"pipeline\": null,\n                    \"supervisionId\": null\n                },\n                {\n                    \"deviceId\": \"123457\",\n                    \"pipeline\": null,\n                    \"supervisionId\": null\n                },\n                {\n                    \"deviceId\": \"123458\",\n                    \"pipeline\": null,\n                    \"supervisionId\": null\n                }\n            ],\n            \"earlyWarning\": [\n                {\n                    \"deviceId\": \"123459\",\n                    \"pipeline\": null,\n                    \"supervisionId\": null\n                },\n                {\n                    \"deviceId\": \"123450\",\n                    \"pipeline\": null,\n                    \"supervisionId\": null\n                }\n            ],\n            \"alarm\": [\n                {\n                    \"deviceId\": \"123451\",\n                    \"pipeline\": null,\n                    \"supervisionId\": null\n                }\n            ]\n        },\n        \"insertTimeStart\": null,\n        \"insertTimeEnd\": null,\n        \"pageNumber\": 0,\n        \"outSelectSerial\": 0,\n        \"selectFlag\": null,\n        \"companyName\": \"天华餐饮企业\",\n        \"phone\": \"13132746998\",\n        \"address\": null,\n        \"processorIdArray\": null,\n        \"dispatchTime\": null,\n        \"clientEstimate\": null,\n        \"signImg\": null,\n        \"missionImg\": null,\n        \"acceptanceTime\": null,\n        \"updateDispatchTime\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OrderController.java",
    "groupTitle": "operation-订单管理",
    "name": "PostOrderOperationAdd",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/order/operation/add"
      }
    ]
  },
  {
    "type": "post",
    "url": "/order/operation/select",
    "title": "查询订单",
    "version": "0.0.1",
    "description": "<p>运维端管理系统的查询订单接口说明，以下参数无值时为null。</p>",
    "group": "operation-订单管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "foodCompanyId",
            "description": "<p>搜索范围（（默认）当前餐饮企业：对应ID  所有餐饮企业：null）</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "orderStatus",
            "description": "<p>订单状态 (1：已分配（已分配到公司） 2:待确认（等待餐饮企业确认订单） 3：待派单（等待公司派单到员工）  4：待处理（等待员工处理）  5、已完成（含餐饮签名的照片上传）），必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "genType",
            "description": "<p>下单方式（1：餐饮企业下单  2：系统下单  3：运维人员下单）</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "orderType",
            "description": "<p>订单类型（1：设备清洗  2：设备维修  3：设备安装）</p>"
          },
          {
            "group": "入参",
            "type": "date",
            "optional": false,
            "field": "insertTimeStart",
            "description": "<p>起始下单时间</p>"
          },
          {
            "group": "入参",
            "type": "date",
            "optional": false,
            "field": "insertTimeEnd",
            "description": "<p>终止下单时间</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "orderNumber",
            "description": "<p>订单编号</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "flowNum",
            "description": "<p>订单流水号</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "maintenanceCompanyId",
            "description": "<p>派单公司ID</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "processorId",
            "description": "<p>派单员工工号</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "pageNumber",
            "description": "<p>页号（默认为 1）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"orderNumber\": \"162529192730232\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "numberOfPages",
            "description": "<p>页面数量</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "outSelectSerial",
            "description": "<p>序号</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "selectCount",
            "description": "<p>查询到的订单总数</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"numberOfPages\": 1,\n        \"selectResult\": [\n            {\n                \"maintenanceId\": 32,\n                \"maintenanceCompanyId\": 4,\n                \"isDeleted\": false,\n                \"insertTime\": \"2021-07-03 13:58:46.0\",\n                \"updateTime\": \"2021-07-03 14:20:21.0\",\n                \"orderType\": \"设备安装\",\n                \"foodCompanyId\": 1,\n                \"oneProcessorId\": 0,\n                \"money\": 90.5,\n                \"orderStatus\": 2,\n                \"genType\": \"运维\",\n                \"batch\": null,\n                \"time\": \"2021-04-19 00:00:00.0\",\n                \"maintenanceTimeseg\": \"09:00-10:30\",\n                \"remark\": \"电话联系\",\n                \"warnId\": null,\n                \"orderNumber\": \"162529192730232\",\n                \"flowNum\": null,\n                \"devices\": {\n                    \"normal\": [\n                        {\n                            \"deviceId\": \"6\",\n                            \"seqNum\": 10,\n                            \"gateId\": 1\n                        },\n                        {\n                            \"deviceId\": \"7\",\n                            \"seqNum\": 8,\n                            \"gateId\": 1\n                        },\n                        {\n                            \"deviceId\": \"8\",\n                            \"seqNum\": 10,\n                            \"gateId\": null\n                        }\n                    ],\n                    \"earlyWarning\": [],\n                    \"alarm\": []\n                },\n                \"insertTimeStart\": null,\n                \"insertTimeEnd\": null,\n                \"pageNumber\": 1,\n                \"outSelectSerial\": 1,\n                \"selectFlag\": null,\n                \"companyName\": \"寨云居\",\n                \"phone\": \"13132746998\",\n                \"address\": \"广西壮族自治区桂林市象山区龙脊索道北\",\n                \"processorIdArray\": null,\n                \"dispatchTime\": null,\n                \"clientEstimate\": null,\n                \"signImg\": null,\n                \"missionImg\": null,\n                \"acceptanceTime\": \"\",\n                \"updateDispatchTime\": null\n            }\n        ],\n        \"selectCount\": 1,\n        \"dlist\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OrderController.java",
    "groupTitle": "operation-订单管理",
    "name": "PostOrderOperationSelect",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/order/operation/select"
      }
    ]
  },
  {
    "type": "post",
    "url": "/order/operation/update",
    "title": "修改订单",
    "version": "0.0.1",
    "description": "<p>本例为运维端管理系统的修改订单说明。</p>",
    "group": "operation-订单管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "orderType",
            "description": "<p>订单类型编码（设备清洗  设备维修  设备安装），必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "foodCompanyId",
            "description": "<p>餐饮企业ID，必填</p>"
          },
          {
            "group": "入参",
            "type": "double",
            "optional": false,
            "field": "money",
            "description": "<p>订单金额</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "time",
            "description": "<p>维保日期，必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "maintenanceTimeSeg",
            "description": "<p>维保时间段（09:00-10:30  10:30-12:00  14:00-15:30 15:30-17:00），必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "genType",
            "description": "<p>订单产生方式（运维 餐饮 系统），必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "batch",
            "description": "<p>订单批次</p>"
          },
          {
            "group": "入参",
            "type": "set",
            "optional": false,
            "field": "devices",
            "description": "<p>设备关联，必填</p>"
          },
          {
            "group": "入参",
            "type": "array",
            "optional": false,
            "field": "normal",
            "description": "<p>正常设备（父级：devices）</p>"
          },
          {
            "group": "入参",
            "type": "array",
            "optional": false,
            "field": "earlyWarning",
            "description": "<p>预警设备（父级：devices）</p>"
          },
          {
            "group": "入参",
            "type": "array",
            "optional": false,
            "field": "alarm",
            "description": "<p>报警设备（父级：devices）</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "deviceId",
            "description": "<p>设备ID（父级：normal||earlyWarning||alarm）</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "maintenanceCompanyId",
            "description": "<p>派单公司ID，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "oneProcessorId",
            "description": "<p>订单上原带有的派单负责人工号，必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "orderNumber",
            "description": "<p>订单编号（不可修改），必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "flowNum",
            "description": "<p>订单流水号（不可修改），必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "orderStatus",
            "description": "<p>订单状态 (1：已分配（已分配到公司） 2:待确认（等待餐饮企业确认订单） 3：待派单（等待公司派单到员工）  4：待处理（等待员工处理）  5、已完成（含餐饮签名的照片上传）），必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "gateId",
            "description": "<p>监管设备ID，此数值在添加设备时已经确定，此处不支持修改，由设备号带过来（7.3修改）</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "seqNum",
            "description": "<p>监管设备的管道号，此数值在添加设备时已经确定，此处不支持修改，由设备号带过来（7.3修改）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"maintenanceId\": 17,\n    \"maintenanceCompanyId\": 4,\n    \"isDeleted\": null,\n    \"insertTime\": \"2021-06-23 20:01:14\",\n    \"updateTime\": null,\n    \"orderType\": \"设备维修\",\n    \"foodCompanyId\": 1,\n    \"oneProcessorId\": 0,\n    \"money\": 100,\n    \"orderStatus\": 1,\n    \"genType\": \"运维\",\n    \"batch\": null,\n    \"time\": \"2021-04-19\",\n    \"maintenanceTimeseg\": \"09:00-10:30\",\n    \"remark\": \"电话联系\",\n    \"warnId\": null,\n    \"orderNumber\": \"162444967488817\",\n    \"flowNum\": null,\n    \"devices\": {\n        \"normal\": [\n            {\n                \"deviceId\": \"123456\"\n            },\n            {\n                \"deviceId\": \"123457\"\n            },\n            {\n                \"deviceId\": \"123458\"\n            }\n        ],\n        \"earlyWarning\": [\n            {\n                \"deviceId\": \"123459\"\n            },\n            {\n                \"deviceId\": \"123450\"\n            }\n        ],\n        \"alarm\": [\n        ]\n    },\n    \"insertTimeStart\": null,\n    \"insertTimeEnd\": null,\n    \"pageNumber\": 0,\n    \"outSelectSerial\": 0,\n    \"selectFlag\": null,\n    \"companyName\": \"天华餐饮企业\",\n    \"phone\": \"13132746998\",\n    \"address\": null,\n    \"processorIdArray\": null,\n    \"dispatchTime\": null,\n    \"clientEstimate\": null,\n    \"signImg\": null,\n    \"missionImg\": null,\n    \"acceptanceTime\": null,\n    \"updateDispatchTime\": null\n}",
          "type": "json"
        },
        {
          "title": "安装订单添加设备入参样例：",
          "content": "{\n\n    \"maintenanceId\": 32,\n    \"maintenanceCompanyId\": 1,\n    \"isDeleted\": null,\n    \"insertTime\": \"2021-07-03 13:58:46\",\n    \"updateTime\": null,\n    \"orderType\": \"设备安装\",\n    \"foodCompanyId\": 1,\n    \"oneProcessorId\": 0,\n    \"money\": 90.5,\n    \"orderStatus\": 1,\n    \"genType\": \"运维\",\n    \"batch\": null,\n    \"time\": \"2021-04-19\",\n    \"maintenanceTimeseg\": \"09:00-10:30\",\n    \"remark\": \"电话联系\",\n    \"warnId\": null,\n    \"orderNumber\": \"162529192730232\",\n    \"flowNum\": null,\n    \"devices\": {\n        \"normal\": [\n                {\n                    \"deviceId\": \"6\",\n                    \"seqNum\": 10,\n                    \"gateId\": 1\n                },\n                {\n                    \"deviceId\": \"7\",\n                    \"seqNum\": 8,\n                    \"gateId\": 1\n                },\n                {\n                    \"deviceId\": \"8\",\n                    \"seqNum\": 10,\n                    \"gateId\": null\n                }\n    ],\n        \"earlyWarning\": [],\n        \"alarm\": []\n    },\n    \"insertTimeStart\": null,\n    \"insertTimeEnd\": null,\n    \"pageNumber\": 0,\n    \"outSelectSerial\": 0,\n    \"selectFlag\": null,\n    \"companyName\": \"寨云居\",\n    \"phone\": \"13132746998\",\n    \"address\": \"广西壮族自治区桂林市象山区龙脊索道北\",\n    \"processorIdArray\": null,\n    \"dispatchTime\": null,\n    \"clientEstimate\": null,\n    \"signImg\": null,\n    \"missionImg\": null,\n    \"acceptanceTime\": null,\n    \"updateDispatchTime\": null\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-订单更新成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "devices",
            "description": "<p>设备关联</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"订单更新成功\",\n    \"data\": {\n        \"maintenanceId\": 32,\n        \"maintenanceCompanyId\": 1,\n        \"isDeleted\": false,\n        \"insertTime\": \"2021-07-03 13:58:46.0\",\n        \"updateTime\": \"2021-07-03 14:20:21.0\",\n        \"orderType\": \"设备安装\",\n        \"foodCompanyId\": 1,\n        \"oneProcessorId\": 0,\n        \"money\": 90.5,\n        \"orderStatus\": 1,\n        \"genType\": \"运维\",\n        \"batch\": null,\n        \"time\": \"2021-04-19 00:00:00.0\",\n        \"maintenanceTimeseg\": \"09:00-10:30\",\n        \"remark\": \"电话联系\",\n        \"warnId\": null,\n        \"orderNumber\": \"162529192730232\",\n        \"flowNum\": null,\n        \"devices\": {\n            \"normal\": [\n                {\n                    \"deviceId\": \"6\",\n                    \"seqNum\": 10,\n                    \"gateId\": 1\n                },\n                {\n                    \"deviceId\": \"7\",\n                    \"seqNum\": 8,\n                    \"gateId\": 1\n                },\n                {\n                    \"deviceId\": \"8\",\n                    \"seqNum\": 10,\n                    \"gateId\": null\n                }\n            ],\n            \"earlyWarning\": [],\n            \"alarm\": []\n        },\n        \"insertTimeStart\": null,\n        \"insertTimeEnd\": null,\n        \"pageNumber\": 0,\n        \"outSelectSerial\": 0,\n        \"selectFlag\": null,\n        \"companyName\": \"寨云居\",\n        \"phone\": \"13132746998\",\n        \"address\": \"广西壮族自治区桂林市象山区龙脊索道北\",\n        \"processorIdArray\": null,\n        \"dispatchTime\": null,\n        \"clientEstimate\": null,\n        \"signImg\": null,\n        \"missionImg\": null,\n        \"acceptanceTime\": null,\n        \"updateDispatchTime\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OrderController.java",
    "groupTitle": "operation-订单管理",
    "name": "PostOrderOperationUpdate",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/order/operation/update"
      }
    ]
  },
  {
    "type": "post",
    "url": "/order/update/status",
    "title": "更新订单状态",
    "version": "0.0.1",
    "description": "<p>根据订单号更新订单状态，目前仅供用户支付后更改订单状态使用，其它某些地方使用会出问题。</p>",
    "group": "operation-订单管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "orderStatus",
            "description": "<p>订单状态 (1：已分配（已分配到公司） 2:待确认（等待餐饮企业确认订单） 3：待派单（等待公司派单到员工）  4：待处理（等待员工处理）  5、已完成（含餐饮签名的照片上传）），必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "orderNumber",
            "description": "<p>订单编号，必填</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"orderNumber\": \"161797298403681\",\n    \"orderStatus\": 3\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-更新订单状态成功；2001-数据库执行有异常；1201-请求条件中，缺少必填参数；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"更新订单状态成功\"\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/OrderController.java",
    "groupTitle": "operation-订单管理",
    "name": "PostOrderUpdateStatus",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/order/update/status"
      }
    ]
  },
  {
    "type": "get",
    "url": "/devices/delete?deviceId=20210410",
    "title": "删除设备",
    "version": "0.0.1",
    "description": "<p>运维端管理系统-餐饮企业-设备管理之删除设备接口说明。</p>",
    "group": "operation-设备管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "deviceId",
            "description": "<p>设备ID（唯一识别），必填。</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-订单删除成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"删除设备成功\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/DeviceController.java",
    "groupTitle": "operation-设备管理",
    "name": "GetDevicesDeleteDeviceid20210410",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/devices/delete?deviceId=20210410"
      }
    ]
  },
  {
    "type": "get",
    "url": "/select/device/monitor/info?deviceId=20210488",
    "title": "查询设备监控信息",
    "version": "0.0.1",
    "description": "<p>查询设备的相关监控信息。</p>",
    "group": "operation-设备管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "deviceId",
            "description": "<p>设备ID</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码：200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "deviceId",
            "description": "<p>设备ID（唯一识别）</p>"
          },
          {
            "group": "出参",
            "type": "boolean",
            "optional": false,
            "field": "isOnline",
            "description": "<p>设备实时运行状况监测（true：运行  false：停止）</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "updateTime",
            "description": "<p>参数更新时间</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "nextTime",
            "description": "<p>距离下次维保还剩多少小时</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "status",
            "description": "<p>三种类型：正常、预警、报警</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "realRunningTime",
            "description": "<p>本次开机运行时长(秒)  (注：时间戳对应年月日时分秒！！！)</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "totalUsedTime",
            "description": "<p>设备自安装累计使用时长</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "useTimeAfterMaintenance",
            "description": "<p>设备维保后使用时长（秒）</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "lastTime",
            "description": "<p>上次维保时间</p>"
          },
          {
            "group": "出参",
            "type": "date",
            "optional": false,
            "field": "nearMaintanceTime",
            "description": "<p>上次维保时间</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "maintenanceNum",
            "description": "<p>设备维保次数</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"deviceId\": \"20210488\",\n        \"paramId\": null,\n        \"isOnline\": false,\n        \"isDeleted\": null,\n        \"insertTime\": null,\n        \"updateTime\": \"2021-05-29 22:59:03.0\",\n        \"nextTime\": null,\n        \"status\": \"1\",\n        \"maintenanceNum\": 25,\n        \"startStopNum\": null,\n        \"nearOnlineTime\": \"2021-07-02T13:06:30.000+0000\",\n        \"nearOfflineTime\": null,\n        \"maintenanceRound\": null,\n        \"totalUsedTime\": \"0\",\n        \"realRunningTime\": \"677600\",\n        \"useTimeAfterMaintenance\": \"152898\",\n        \"lastTime\": \"2021-07-08 22:51:32.0\",\n        \"nearMaintanceTime\": \"2021-07-08T14:51:32.000+0000\"\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\t\"Code\": 2001,\n\t\"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/DeviceRunparamController.java",
    "groupTitle": "operation-设备管理",
    "name": "GetSelectDeviceMonitorInfoDeviceid20210488",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/select/device/monitor/info?deviceId=20210488"
      }
    ]
  },
  {
    "type": "post",
    "url": "/add/device",
    "title": "新增设备",
    "version": "0.0.1",
    "description": "<p>运维端管理系统-餐饮企业-设备管理之新增设备接口说明。</p>",
    "group": "operation-设备管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "deviceId",
            "description": "<p>设备ID（唯一识别），手动填入，是设备出厂编号，必填。</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>所属餐饮企业ID，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "manufacturerId",
            "description": "<p>设备厂商ID，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "gateId",
            "description": "<p>监管设备ID，必填，增加删除修改相关信息均调用此接口，结果原样返回。(增删改查都已支持)</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "seqNum",
            "description": "<p>监管设备的管道号，必填，增加删除修改相关信息均调用此接口，结果原样返回。(增删改查都已支持)</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "nearMaintanceTime",
            "description": "<p>上次维保时间</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "maintenanceRound",
            "description": "<p>维保周期</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"seqNum\": 5,\n    \"gateId\": 1,\n    \"deviceId\": \"20210710\",\n    \"companyId\": 1,\n    \"manufacturerId\": 1,\n    \"nearMaintanceTime\": \"2021-07-03 22:51:32\",\n    \"maintenanceRound\": \"30\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-新增设备成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "deviceId",
            "description": "<p>设备ID（唯一识别）</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>所属餐饮企业ID</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "manufacturerId",
            "description": "<p>设备厂商ID</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "insertTime",
            "description": "<p>设备注册时间</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "seqNum",
            "description": "<p>在餐饮企业序号（第几个设备）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"新增设备成功\",\n    \"data\": {\n        \"deviceId\": \"20210528\",\n        \"companyId\": 1,\n        \"manufacturerId\": 1,\n        \"deviceCode\": \"20210710\",\n        \"deviceName\": null,\n        \"insertTime\": \"2021-07-10 15:47:46\",\n        \"updateTime\": null,\n        \"isDeleted\": null,\n        \"seqNum\": 5,\n        \"gateId\": 1,\n        \"status\": null,\n        \"isOnline\": null,\n        \"allRunTime\": null,\n        \"maintenanceNum\": null,\n        \"maintenanceRound\": 30,\n        \"nextTime\": null,\n        \"startStopNum\": null,\n        \"earlyWarningNum\": null,\n        \"alarmNum\": null,\n        \"pageNumber\": 0,\n        \"outSelectSerial\": 0,\n        \"pipeline\": null,\n        \"supervisionId\": null,\n        \"nearMaintanceTime\": \"2021-07-03 22:51:32\"\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/DeviceController.java",
    "groupTitle": "operation-设备管理",
    "name": "PostAddDevice"
  },
  {
    "type": "post",
    "url": "/select/device",
    "title": "查询设备",
    "version": "0.0.1",
    "description": "<p>运维端管理系统-餐饮企业-设备管理之查询设备接口说明，将选以下参数作为查询条件，不选为null。</p>",
    "group": "operation-设备管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "deviceId",
            "description": "<p>设备ID（唯一识别），即设备编码。</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>所属餐饮企业ID</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "manufacturerId",
            "description": "<p>设备厂商ID</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "status",
            "description": "<p>设备状态（正常、预警、报警）</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "isOnline",
            "description": "<p>停止/运行（0：停止  1：运行）</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "seqNum",
            "description": "<p>监管设备ID。</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "gateId",
            "description": "<p>监管设备的管道号。</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-设备查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "deviceId",
            "description": "<p>设备编号</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>所属餐饮企业ID</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "manufacturerId",
            "description": "<p>设备厂商ID</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "status",
            "description": "<p>设备状态（正常、预警、报警）</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "isOnline",
            "description": "<p>停止/运行（0：停止  1：运行）</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "totalUsedTime",
            "description": "<p>设备安装以来的运行时长运行时长（分）</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "maintenanceNum",
            "description": "<p>维保次数</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "maintenanceRound",
            "description": "<p>维保周期（天）</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "nearMaintanceTime",
            "description": "<p>上次维保时间</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "nextTime",
            "description": "<p>下次维保时间</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "startStopNum",
            "description": "<p>启停次数（超链接）</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "seqNum",
            "description": "<p>在餐饮企业序号（第几个设备）</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "insertTime",
            "description": "<p>设备注册时间</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "updateTime",
            "description": "<p>设备信息修改时间</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "dlist",
            "description": "<p>查询结果集</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "numberOfPages",
            "description": "<p>页面数量</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "outSelectSerial",
            "description": "<p>订单序号</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "selectCount",
            "description": "<p>查询到的订单总数</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询设备成功\",\n    \"data\": {\n        \"numberOfPages\": 1,\n        \"selectResult\": null,\n        \"selectCount\": 2,\n        \"dlist\": [\n            {\n                \"deviceId\": \"20210410\",\n                \"companyId\": 2,\n                \"manufacturerId\": 1,\n                \"deviceCode\": null,\n                \"deviceName\": null,\n                \"insertTime\": \"2021-04-07 20:10:38\",\n                \"updateTime\": null,\n                \"isDeleted\": null,\n                \"seqNum\": 1,\n                \"status\": \"正常\",\n                \"isOnline\": 1,\n                \"allRunTime\": 1234,\n                \"maintenanceNum\": 1,\n                \"maintenanceRound\": null,\n                \"nextTime\": \"2021-04-30 16:57:12.0\",\n                \"startStopNum\": 1,\n                \"earlyWarningNum\": 2,\n                \"alarmNum\": 3,\n                \"pageNumber\": 1,\n                \"outSelectSerial\": 1,\n                \"seqNum\": 2,\n                \"gateId\": 2\n            },\n            {\n                \"deviceId\": \"20210412\",\n                \"companyId\": 4,\n                \"manufacturerId\": 2,\n                \"deviceCode\": null,\n                \"deviceName\": null,\n                \"insertTime\": \"2021-04-07 20:32:25\",\n                \"updateTime\": \"2021-04-07 21:05:03\",\n                \"isDeleted\": null,\n                \"seqNum\": 1,\n                \"status\": null,\n                \"isOnline\": null,\n                \"allRunTime\": null,\n                \"maintenanceNum\": null,\n                \"maintenanceRound\": null,\n                \"nextTime\": null,\n                \"startStopNum\": null,\n                \"earlyWarningNum\": null,\n                \"alarmNum\": null,\n                \"pageNumber\": 1,\n                \"outSelectSerial\": 2\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/DeviceController.java",
    "groupTitle": "operation-设备管理",
    "name": "PostSelectDevice",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/select/device"
      }
    ]
  },
  {
    "type": "post",
    "url": "/update/device",
    "title": "修改设备",
    "version": "0.0.1",
    "description": "<p>运维端管理系统-餐饮企业-设备管理之修改设备信息接口说明。</p>",
    "group": "operation-设备管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "deviceId",
            "description": "<p>设备ID（唯一识别），不可修改，必填。</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>所属餐饮企业ID，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "manufacturerId",
            "description": "<p>设备厂商ID，必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "nearMaintanceTime",
            "description": "<p>上次维保时间</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "maintenanceRound",
            "description": "<p>维保周期</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"seqNum\": 10,\n    \"gateId\": 5,\n    \"deviceId\": \"20210488\",\n    \"companyId\": 2,\n    \"manufacturerId\": 1,\n    \"nearMaintanceTime\": \"2021-07-08 22:51:32\",\n    \"maintenanceRound\": \"60\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-设备信息修改成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "deviceId",
            "description": "<p>设备ID（唯一识别）</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "companyId",
            "description": "<p>所属餐饮企业ID</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "manufacturerId",
            "description": "<p>设备厂商ID</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "insertTime",
            "description": "<p>设备注册时间</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "updateTime",
            "description": "<p>设备信息修改时间</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "seqNum",
            "description": "<p>在餐饮企业序号（第几个设备）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"修改设备信息成功\",\n    \"data\": {\n        \"deviceId\": \"20210488\",\n        \"companyId\": 2,\n        \"manufacturerId\": 1,\n        \"deviceCode\": \"PDI8564\",\n        \"deviceName\": null,\n        \"insertTime\": \"2021-07-06 12:54:08.0\",\n        \"updateTime\": \"2021-07-10 16:46:21.0\",\n        \"isDeleted\": false,\n        \"seqNum\": 10,\n        \"gateId\": 5,\n        \"status\": null,\n        \"isOnline\": null,\n        \"allRunTime\": null,\n        \"maintenanceNum\": null,\n        \"maintenanceRound\": 60,\n        \"nextTime\": null,\n        \"startStopNum\": null,\n        \"earlyWarningNum\": null,\n        \"alarmNum\": null,\n        \"pageNumber\": 0,\n        \"outSelectSerial\": 0,\n        \"pipeline\": null,\n        \"supervisionId\": null,\n        \"nearMaintanceTime\": \"2021-07-08 22:51:32.0\"\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/DeviceController.java",
    "groupTitle": "operation-设备管理",
    "name": "PostUpdateDevice",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/update/device"
      }
    ]
  },
  {
    "type": "get",
    "url": "/news/push",
    "title": "消息推送",
    "version": "0.0.1",
    "description": "<p>推送消息：预警/报警、会员到期。</p>",
    "group": "restaurant-消息推送",
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-消息更新成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "memberExpire",
            "description": "<p>所有的会员即将到期列表。例：Id为1的餐饮企业会员即将过期，可通知的人员有两位；若有其它餐饮企业会员即将过期，类似前述信息也会出现在这里。</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "abnormalDeviceInfo",
            "description": "<p>所有的预警/报警设备列表。数组里是：哪家的哪个设备出现故障可通知哪些人员。</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "device_id",
            "description": "<p>改为id，意仍为设备ID</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n\"code\": 200,\n\"message\": \"消息更新成功\",\n\"data\": {\n\"memberExpire\": [\n{\n\"company_id\": 1,\n\"openid\": \"oBtC65KeWP0E_FFe8trbI3RuBJ0B\",\n\"message\": \"会员即将到期\"\n},\n{\n\"company_id\": 1,\n\"openid\": \"sfggr68599\",\n\"message\": \"会员即将到期\"\n}\n],\n\"abnormalDeviceInfo\": [\n{\n\"id\": 20210410,\n\"company_id\": 2,\n\"openid\": \"235295034gfdsfg\",\n\"warn_message\": \"预警\"\n},\n{\n\"id\": 20210410,\n\"company_id\": 2,\n\"openid\": \"oBtC65KeWP0E_FFe8trbI3RuBJ0A\",\n\"warn_message\": \"预警\"\n}\n]\n}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n\"Code\": \"2001\",\n\"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/NewsPushController.java",
    "groupTitle": "restaurant-消息推送",
    "name": "GetNewsPush",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/news/push"
      }
    ]
  },
  {
    "type": "get",
    "url": "/gate/devices/delete?deviceId=20210410",
    "title": "删除监管/网关设备",
    "version": "0.0.1",
    "description": "<p>运维方-上门扫码-设备管理之删除监管/网关设备接口说明</p>",
    "group": "监管或网关设备管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>设备ID（唯一识别），必填，系统生成。</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-订单删除成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"删除成功\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/NetworkGateController.java",
    "groupTitle": "监管或网关设备管理",
    "name": "GetGateDevicesDeleteDeviceid20210410",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/gate/devices/delete?deviceId=20210410"
      }
    ]
  },
  {
    "type": "post",
    "url": "/gate/add/device",
    "title": "新增监管/网关设备",
    "version": "0.0.1",
    "description": "<p>运维方-上门扫码-设备管理之新增监管/网关设备接口说明。</p>",
    "group": "监管或网关设备管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "deviceCode",
            "description": "<p>设备编码，手动填入，是设备出厂编号。</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "channelNum",
            "description": "<p>通道数量</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"deviceCode\": \"ceshi1\",\n    \"channelNum\": 16\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-新增设备成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>监管/网关设备在系统中的唯一id</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"注册成功\",\n    \"data\": {\n        \"id\": 30,\n        \"deviceCode\": \"ceshi1\",\n        \"channelNum\": 16,\n        \"companyId\": null,\n        \"ipAddress\": null,\n        \"mac\": null,\n        \"usedChannelNum\": null,\n        \"freeChannelNum\": null,\n        \"isDeleted\": null,\n        \"insertTime\": \"2021-07-06 11:35:06\",\n        \"updateTime\": null,\n        \"status\": null,\n        \"warnId\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/NetworkGateController.java",
    "groupTitle": "监管或网关设备管理",
    "name": "PostGateAddDevice"
  },
  {
    "type": "post",
    "url": "/gate/select/device",
    "title": "查询监管/网关设备",
    "version": "0.0.1",
    "description": "<p>运维方-上门扫码-设备管理之查询监管/网关设备接口说明</p>",
    "group": "监管或网关设备管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "description",
            "description": "<p>可支持以下条件查询，null为{}</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n            \"id\": 6,\n            \"deviceCode\": \"fiuweg3988\",\n            \"channelNum\": 16,\n            \"companyId\": null,\n            \"ipAddress\": null,\n            \"mac\": null,\n            \"usedChannelNum\": 0,\n            \"freeChannelNum\": 0,\n            \"isDeleted\": false,\n            \"status\": null,\n            \"warnId\": null\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-设备查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": [\n        {\n            \"id\": 6,\n            \"deviceCode\": \"fiuweg3988\",\n            \"channelNum\": 16,\n            \"companyId\": null,\n            \"ipAddress\": null,\n            \"mac\": null,\n            \"usedChannelNum\": 0,\n            \"freeChannelNum\": 0,\n            \"isDeleted\": false,\n            \"insertTime\": \"2021-07-03 16:28:37.0\",\n            \"updateTime\": null,\n            \"status\": null,\n            \"warnId\": null\n        }\n    ]\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/NetworkGateController.java",
    "groupTitle": "监管或网关设备管理",
    "name": "PostGateSelectDevice",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/gate/select/device"
      }
    ]
  },
  {
    "type": "post",
    "url": "/gate/update/device",
    "title": "修改监管/网关设备",
    "version": "0.0.1",
    "description": "<p>运维方-上门扫码-设备管理之修改监管/网关设备接口说明</p>",
    "group": "监管或网关设备管理",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>设备ID（唯一识别），不可修改，必填。</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "description",
            "description": "<p>可根据id选择性修改下内容。</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"id\": 4,\n    \"channelNum\": 12,\n    \"companyId\": null,\n    \"ipAddress\": null,\n    \"mac\": null,\n    \"usedChannelNum\": 0,\n    \"freeChannelNum\": 0,\n    \"status\": null,\n    \"warnId\": null\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-设备信息修改成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"修改成功\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"Code\": \"2001\",\n\t   \"Message\": \"数据库执行有异常\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "server/kitchen-provider/src/main/java/cn/guet/kitchen/controller/NetworkGateController.java",
    "groupTitle": "监管或网关设备管理",
    "name": "PostGateUpdateDevice",
    "sampleRequest": [
      {
        "url": "https://m170973k01.51mypc.cn/kitcken_api/gate/update/device"
      }
    ]
  }
] });
