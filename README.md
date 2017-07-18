# RecylerView
recycler-itemDcoration
实现功能
1.recyclerView分割线的自定义 <包括size color etc...>
2.recyclerView 不同type的不同item的显示 
3.自带粘性头的recyclerView的实现


下面看核心代码:
public CustomDecoration(Context context) {
        //super();
        paint = new Paint();
        paint.setColor(context.getResources().getColor(R.color.colorAccent));
        twoPaint = new Paint();
        twoPaint.setColor(context.getResources().getColor(R.color.colorPrimary));
        dirHeight = context.getResources().getDimensionPixelSize(R.dimen.divider_height);
        firstWidth = context.getResources().getDimensionPixelSize(R.dimen.divider_width_first);
        secondWidth = context.getResources().getDimensionPixelSize(R.dimen.divider_width_second);


        textPaint = new TextPaint();
        textPaint.setTextSize(50);
        textPaint.setAntiAlias(true);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setColor(Color.BLACK);
        fontMetrics = new Paint.FontMetrics();
        textPaint.getFontMetrics(fontMetrics);
        textPaint.setTextAlign(Paint.Align.LEFT);
        topGap = context.getResources().getDimensionPixelSize(R.dimen.sectioned_top);

        typePaint = new Paint();
        typePaint.setColor(Color.GRAY);

    }
    在构造中配置;
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        /*int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            //outRect.bottom = dirHeight + childAt.getBottom();
            outRect.bottom = dirHeight ;
        }*/
        //outRect.bottom = 300 ;
        int pos = parent.getChildAdapterPosition(view);
        if (pos % 10 == 0 ) {//同组的第一个才添加padding
            outRect.top = topGap;
        }

    }
    在ItemDecoration的getItemOffsets中配置每一个item的padding值
    
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            c.drawRect(childAt.getLeft(),childAt.getBottom(),childAt.getRight(),childAt.getBottom() + dirHeight,paint);
        }
    }
    在onDraw中实现分割线
    
    
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        //int itemCount = state.getItemCount();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            int pos = parent.getChildAdapterPosition(childAt);
           /* if (pos % 10 == 0){
                int left = childAt.getLeft();
                int right = childAt.getRight();
                int top = childAt.getTop() - topGap;
                int bottom = childAt.getTop();

                c.drawRect(left,top,right,bottom,typePaint);
                c.drawText("super_starts",left,bottom - 10,textPaint);
            }*/
            if (pos % 2 == 0){
                c.drawRect(childAt.getLeft(),childAt.getTop(),childAt.getLeft() + firstWidth,childAt.getBottom(),paint);
            }else{
                c.drawRect(childAt.getRight() - secondWidth,childAt.getTop(),childAt.getRight(),childAt.getBottom(),twoPaint);
            }
        }

        int itemCount = state.getItemCount();
        //int childCount = parent.getChildCount();

        //float lineHeight = textPaint.getTextSize() + fontMetrics.descent;
        //long preGroupId, groupId = -1;
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int left = view.getLeft();
            int right = view.getRight();
            int position = parent.getChildAdapterPosition(view);
            preGroupId = groupId;
            groupId = getGroupId(position);
            if (position % 10 != 0){
                if (groupId < 0 || groupId == preGroupId){
                    continue;
                }
            }



            int viewBottom = view.getBottom();
            float textY = Math.max(topGap, view.getTop());
            if ( position + 1 < itemCount) {
                //下一个和当前不一样移动当前
                long nextGroupId = getGroupId(position + 1);
                if (nextGroupId != groupId && viewBottom < textY ) {
                    //组内最后一个view进入了header
                    textY = viewBottom;
                }
            }
            c.drawRect(left, textY - topGap, right, textY, typePaint);
            c.drawText("super_starts", left, textY - 10, textPaint);
            /*if (position % 10 == 0){
                c.drawRect(left, textY - topGap, right, textY, typePaint);
                c.drawText("super_starts", left, textY - 10, textPaint);
            }*/


        }



    }
    在onDrawOver中实现分类实现 和粘性头
