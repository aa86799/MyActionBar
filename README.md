# MyActionBar

[2.1,3.0) 使用support-v7中的ActionBar
    使用兼容性的ActionBar，需要设置或继承主题 Theme.AppCompat...
    activity需要继承自 android.support.v7.app.ActionBarActivity;（在5.0过时）
在api21(5.0)之后继承自 android.support.v7.app.AppCompatActivity
    在activity上必须使用AppCompat相关Theme


移除ActionBar
    ActionBar actionBar = getSupportActionBar(); //兼容性
    actionBar.hide();//hide后再show 会触发activity重新布局
    //On API level 11 or higher  即3.0以上
    ActionBar actionBar = getActionBar();

当运行activity后，会调用onCreateOptionsMenu()，加载menu相关的xml文件。
menu中的item 如：
<item
        android:id="@+id/action_search"
        android:icon="@android:drawable/ic_menu_search"
        android:title="@string/action_search"
        app:showAsAction="always" />
   showAsAction的取值范围：
            ifRoom      屏幕有足够的空间才会显示操作项，否则会折叠到"溢出"里
            withText    菜单项的图标和标题文字都会在操作栏中显示(在3.0以下优化只显示图标)
            always      操作栏中会一直显示该操作项,即使屏幕显示不下
            never       永不显示 ,会显示在“溢出”里
            collapseActionView  将操作视图折叠到一个操作项上
   显示图标时，长按会弹出title

使用三方 actionbarsherlock