# BCELCode
对文件进行BCEL编码和解码

本工具基于Java开发，主要用来对指定文件进行编码和解码。由于每次更换payload时都要重新运行一次，所以就写了这款工具
# 免责声明

依据中华人民共和国网络安全法第二十七条：任何个人和组织不得从事非法侵入他人网络、干扰他人网络正常功能、窃取网络数据等危害网络安全的活动；不得提供专门用于侵入网络、干扰网络正常功能及防护措施、窃取网络数据等危害网络安全活动的程序、工具；明知他人从事危害网络安全的活动的不得为其提供技术支持、广告推广、支付结算等帮助。

使用本工具则默认遵守网络安全法
# 使用说明

显示帮助信息<br/>
``` Java -jar BCELCode.jar ```<br/>

![image](https://user-images.githubusercontent.com/57057346/145620019-c54e4ab9-87b1-4598-9221-294857bd2325.png)<br/>

对文件进行编码，并在工具文件夹下生成txt文件<br/>
``` Java -jar BCELCode.jar -e FilePth ```<br/>

![image](https://user-images.githubusercontent.com/57057346/145620866-5bcd73ad-2019-457b-91a1-d44b1f77855d.png)<br/>

对文件进行解码，并在工具文件夹下生成class文件<br/>
``` Java -jar BCELCode.jar -d FilePath ```<br/>

![image](https://user-images.githubusercontent.com/57057346/145621676-5c1fe8ac-9dba-4891-8302-8ed7bcfec918.png)<br/>
