# ZoomImageView-Demo

## 自定义可缩放图片的ImageView——ZoomImageView。
- 多指缩放，支持两个以上手指的图片缩放
- 双击缩放，有两个缩放等级，分别是2倍和4倍
- 与ViewPager兼容，防止移动操作手势的冲突

------

## 大致思路：
- 继承OnGlobalLayoutListener，实现onGlobalLayout()方法，在该方法中设置各个缩放比例，设置图片的Matrix缩放、偏移等；
 - 在onAttachedToWindow()方法中添加监听：getViewTreeObserver().addOnGlobalLayoutListener(this);
 - 在onDetachedFromWindow()方法中移除监听：getViewTreeObserver().removeOnGlobalLayoutListener(this);
 - 这一步完成了图片的居中显示，以及图片的压缩。

- 继承ScaleGestureDetector.OnScaleGestureListener，实现onScale()方法，设置缩放手势的监听，进行相应的操作；
 - 注意onScaleBegin()这个方法的返回值要设置为true；
 - 继承OnTouchListener接口，在onTouch()方法中，将触摸事件交给scaleGestureDetector对象去消费；
 - 这一步完成了图片的多指缩放。

- 图片的缩放中心设置为手势中心时，可能会出现边界留白的情况，所以要进行图片边界以及中心位置的控制：
 - 当图片宽高有一项是大于控件大小，根据各种可能出现留白的情况进行图片偏移量的设置；
 - 当图片缩放到宽高都小于控件大小，则把图片中心移动到控件中心；
 - 这一步完成了图片多指缩放之后显示位置的优化。

- 图片的自由移动：覆写onTouch()方法，根据手指个数和移动位置来判断是移动图片还是缩放图片
 - 获取最后一次的X、Y方向的手势中心，当前后两次偏移量超过一定的值，则移动图片；
 - 手指个数发生变化，则各个数值要重新设置；
 - 使用上一步的方法进行边界的处理，否则会导致图片移动到控件以外的地方；
 - 这一步完成了图片的移动，但是和ViewPager有冲突。
	
- 双击时的缩放：new一个SimpleOnGestureListener接口，覆写onDoubleTap方法，将接口传入GestureDetector对象中
 - 获取双击位置，根据当前缩放比例，来控制接下来的缩放大小
 - 自定义一个Runnable，在runnable中每次缩放一个固定的值，然后将当前缩放比和目标值进行对比，不断postDelay()直到达到目标值，同时定义一个变量，防止用户重复地双击。

- 兼容ViewPager：在放大情况下可移动图片而不是切换图片页面;
 - 当图片宽度大于控件宽度，则调用getParent().requestDisallowInterceptTouchEvent(true)；
 - 当图片已经达到边界，可以切换页面。
 
 -----
 
 ## 完整视频教程可查看http://www.imooc.com/learn/239
