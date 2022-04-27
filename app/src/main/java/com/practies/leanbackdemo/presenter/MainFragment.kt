package com.practies.leanbackdemo.presenter

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import com.practies.leanbackdemo.MovieList.imageList
import com.practies.leanbackdemo.R
import com.practies.leanbackdemo.model.SingleRowView

class MainFragment:BrowseSupportFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUI()
    }

    private fun setUI() {

        title="SmartTv"
        headersState= HEADERS_ENABLED
        brandColor= ContextCompat.getColor(requireContext(), R.color.colorPrimary)

        loadRow()
    }

    private fun loadRow() {
        val category1=HeaderItem(0,"Movies")
        val category2=HeaderItem(1,"Shows")
        val category3=HeaderItem(2,"News")

        val row1ArrayObjectAdapter=ArrayObjectAdapter(CardPresenter() )

        val row2ArrayObjectAdapter=ArrayObjectAdapter(CardPresenter())

        row1ArrayObjectAdapter.add(SingleRowView("Avatar",imageList[0]))
        row1ArrayObjectAdapter.add(SingleRowView("SpiderMan",imageList[1]))
        row1ArrayObjectAdapter.add(SingleRowView("Avengers",imageList[2]))

//        row2ArrayObjectAdapter.add(SingleRowView("Avatar",imageList[0]))
//        row2ArrayObjectAdapter.add(SingleRowView("SpiderMan",imageList[1]))
//        row2ArrayObjectAdapter.add(SingleRowView("Avengers",imageList[2]))






        val windowAdapter=ArrayObjectAdapter(ListRowPresenter())

        windowAdapter.add(ListRow(category1,row1ArrayObjectAdapter))
        windowAdapter.add(ListRow(category2,row1ArrayObjectAdapter))
        windowAdapter.add(ListRow(category3,row1ArrayObjectAdapter))

        adapter=windowAdapter

    }




}