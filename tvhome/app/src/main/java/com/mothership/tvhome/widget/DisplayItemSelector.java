package com.mothership.tvhome.widget;

import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.tv.ui.metro.model.DisplayItem;

/**
 * Created by Shawn on 16/3/8.
 */
public class DisplayItemSelector extends PresenterSelector
{
    private static final String TAG = "DisplayItemSelector";
    SparseArray<Presenter> mPresenters = new SparseArray<Presenter>();
    Presenter mDefaultPresenter = new BasePresenter();
    public DisplayItemSelector()
    {
        mPresenters.put(204, mDefaultPresenter);
    }
    @Override
    public Presenter getPresenter(Object aItem)
    {
        DisplayItem di = (DisplayItem) aItem;
        DisplayItem.UI type = di.ui_type;
        if(type != null)
        {
            return mPresenters.get(di.ui_type.id(), mDefaultPresenter);
        }
        else
        {
            Log.d(TAG, di.title + " doesn't has ui_type");
            return mDefaultPresenter;
        }
    }
}
