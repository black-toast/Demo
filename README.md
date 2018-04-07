# Demo
Blog文章demo

## StatusBarDemo

- 效果图

<img src="screenshot/statusbar1.png" width="30%" /><img src="screenshot/statusbar2.png" width="30%" /><img src="screenshot/statusbar3.png" width="30%" />

- 使用

    
    // 设置透明状态栏，需放在setContentView之前调用
    StatusBarUtils.setTransparentStatusBar(this, false);
    // 更改状态栏字体图标颜色
    StatusBarUtils.setStatusTextColor(!isNight, MainActivity.this);