package org.stockforecast.handler;
/**
 * 1 运行程序时先设置配置文件
   2 设置好配置文件之后存储配置文件
   3 从配置文件中读取（三个）配置信息并且传递给handler
   4 handler根据配置信息调用fetch 抓取前两个网址信息
   5 从fetch中获取的结果传递给parser
   6 得到的数据存储到数据库中
   7 从数据库中获得stockcode，并根据stock获得fetch的url
               重复上述步骤 5，6

 */
public class testHandler
{

}
