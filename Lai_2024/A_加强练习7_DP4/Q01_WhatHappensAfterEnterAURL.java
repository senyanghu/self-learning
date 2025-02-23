package A_加强练习7_DP4;

/*
这道题目问的是当你在浏览器中输入“yahoo.com”时，背后发生了什么。让我为你分步骤解释一下：

1. DNS解析（Domain Name System Resolution）： 当你在浏览器中输入“yahoo.com”并按下回车键时，首先发生的是DNS解析。
浏览器需要将域名“yahoo.com”转换成一个IP地址，以便与Yahoo的服务器进行通信。DNS解析过程会查找DNS服务器来找到与“yahoo.com”对应的IP地址。

2. 建立TCP连接： 一旦获取到IP地址，浏览器会与该IP地址建立一个TCP连接。这通常是在端口80（HTTP）或端口443（HTTPS）上完成的。
TCP连接的建立包括三次握手（Three-way handshake）过程，以确保连接的可靠性。

3. 发送HTTP请求： 建立连接后，浏览器会向Yahoo的服务器发送一个HTTP请求。例如，“GET / HTTP/1.1”，请求主页内容。
HTTP请求头信息还会包含一些浏览器和用户信息，如用户代理（User-Agent）。

4. 服务器处理请求： Yahoo的服务器接收到请求后，会处理该请求并生成响应。这可能涉及从数据库中获取数据、渲染页面、执行后端逻辑等。

5. 发送HTTP响应： 服务器生成响应后，会通过TCP连接将HTTP响应发送回浏览器。HTTP响应包括状态码（如200 OK）、响应头信息以及响应体
（包含HTML文档、图片、CSS、JavaScript等）。

6. 浏览器渲染页面： 浏览器接收到HTTP响应后，会解析HTML文档，并根据其中包含的内容进行渲染。浏览器可能会发送额外的请求以获取所需的资源
（如图片、CSS文件、JavaScript文件）。一旦所有资源都加载完成，浏览器会将完整的网页呈现给用户。
 */
public class Q01_WhatHappensAfterEnterAURL {
}
