# 优易-让优化更简单

简介：

​    优易是湖北移动网优中心自主研发的移动端优化软件，提供小区名称、TAC、PCI、CGI、频点、Band、频率、RSRP、RSRQ、SINR及邻区等实时测试信息，提供百度地图、热力图、4G小区图、规划图、测试log轨迹图等图层生成功能。便于前台人员脱离笨重、耗电的电脑，携带手机即可完成现场查勘、优化等工作。

1、首页：

##### 1)       当前服务小区、邻区基本信息获取

如图所示：优易APP运行在支持4G的安卓手机上。在手机开机、插上SIM卡并且注册到4G网络之后，该APP通过调用安卓手机Telepphony API，可以获取到目前使用的的运营商、IMSI、IMEI、手机型号、安卓版本、当前手机所在的市县街道、经度、纬度、高度，占用的小区名称、TAC、PCI、CGI、频点、Band、频率、RSRP、RSRQ、SINR，最近占用的小区记录。

![../AndroidP/NetSupport/app/release/ScreenShot/主界面.jpg](file:////Users/sen/Library/Group%20Containers/UBF8T346G9.Office/msoclip1/01/clip_image002.png)

 

##### 2)       当前邻区信息

![../AndroidP/NetSupport/app/release/ScreenShot/邻区的副本%202.jpg](file:////Users/sen/Library/Group%20Containers/UBF8T346G9.Office/msoclip1/01/clip_image004.png)

2、地图GIS：

##### 1)       4G小区、规划图、轨迹图、珊格图

可以显示用户当前所在位置及周围4G小区，并将当前占用的主服务小区用红色的线条标记出来。测试log轨迹图层生成功能，具体业务区间设定值为：rsrp > -75dbm  深蓝色，rsrp > -85dbm  浅蓝色，rsrp > -95dbm  绿色，rsrp > -105dbm  黄色，rsrp > -115dbm  红色，rsrp > -125dbm  灰色，rsrp <= -125dbm  黑色。

![../../Pictures/优易/4G小区规划图轨迹图.png](file:////Users/sen/Library/Group%20Containers/UBF8T346G9.Office/msoclip1/01/clip_image006.png)

##### 2)       二维地图、卫星图、热力图。

能切换普通地图、卫星地图、热力图、路况显示，支持放大缩小和旋转；

![../AndroidP/NetSupport/app/release/ScreenShot/热力图、路况图.jpg](file:////Users/sen/Library/Group%20Containers/UBF8T346G9.Office/msoclip1/01/clip_image008.png)

 

3、待定（此模块预留）：

 

 

4、管理：

如图所示，此模块提供数据导入功能及关于app版本等功能管理。

![../../Pictures/优易/管理.png](file:////Users/sen/Library/Group%20Containers/UBF8T346G9.Office/msoclip1/01/clip_image010.png)

##### 1)       基站数据库导入

可以将指定格式的基站数据库，以文件的形式放到手机SD卡-优易目录中（注：当插入SD卡时，优先在SD卡生成-优易目录和目录下相关CSV格式模版，当无SD卡时，会在内置存储卡生成-优易目录和目录下相关CSV格式模版），APP可以识别优易目录下的工参文件中的内容并将基站信息导入到数据库中，完成基站数据库的导入。

可以将文件导入到LitePal数据库中。

可 在线 下载 优易各种数据模版：永久链接: https://pan.baidu.com/s/11w2SVMphQv6yf2oFfr48SA 提取码: ffcr

![../AndroidP/NetSupport/app/release/ScreenShot/文件读取中.jpg](file:////Users/sen/Library/Group%20Containers/UBF8T346G9.Office/msoclip1/01/clip_image012.png)

##### 2)       基站数据模版“4G工参(模板)”

如下图所示：

![img](file:////Users/sen/Library/Group%20Containers/UBF8T346G9.Office/msoclip1/01/clip_image014.png)

##### 3)       基站数据存放路径：SDK卡或内置存储卡下“优易”目录下“4G工参(模板)”表。此模版文件在导入基站数据功能使用一次之后会自动生成。

![../../Pictures/优易/Screenshot_20190506-191744.png](file:////Users/sen/Library/Group%20Containers/UBF8T346G9.Office/msoclip1/01/clip_image016.png)

##### 4)       基站数据查询：

通过输入小区名称、TAC、ENBID等信息查询符合条件的小区（支持模糊查询），并在界面上显示符合条件的小区的地市、CGI、小区名称、EARFCN、TAC、PCI等基本信息信息。

![../AndroidP/NetSupport/app/release/ScreenShot/基站数据库查询.png](file:////Users/sen/Library/Group%20Containers/UBF8T346G9.Office/msoclip1/01/clip_image018.png)

##### 5)       关于：提供说明书及下载渠道

 

##### 6)       更新

获取网络侧该App的最新版本

如果网络侧版本比本地新，则会提示用户更新

![../AndroidP/NetSupport/app/release/ScreenShot/提示更新.jpg](file:////Users/sen/Library/Group%20Containers/UBF8T346G9.Office/msoclip1/01/clip_image020.png)

 

##### 7)       下载完成后弹出安装界面

![../AndroidP/NetSupport/app/release/ScreenShot/下载完成后自动安装.jpg](file:////Users/sen/Library/Group%20Containers/UBF8T346G9.Office/msoclip1/01/clip_image022.png)

 

5、进优易内部需求沟通群，请扫码添加时备注“优易”添加后邀请入群。（由于微信群时限7天，将群二维码更换为群主二维码）

 

![../../Pictures/WechatIMG11.jpeg](file:////Users/sen/Library/Group%20Containers/UBF8T346G9.Office/msoclip1/01/clip_image024.png)