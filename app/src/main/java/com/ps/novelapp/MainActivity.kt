package com.ps.novelapp

import android.graphics.PixelFormat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.bumptech.glide.Glide
import com.ps.novelapp.model.BannerBean
import com.ps.novelapp.mvp.presenter.biz.CommonPresenter
import com.ps.novelapp.mvp.view.BaseActivity
import com.ps.novelapp.mvp.view.viewinf.CommonBaseIV
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<CommonPresenter>(), CommonBaseIV.BannerIV{

    /**
     * 用于演示X5webview实现视频的全屏播放功能 其中注意 X5的默认全屏方式 与 android 系统的全屏方式
     */

    private lateinit var webView: X5WebView

    override fun initBundle() {
    }

    override fun getContentView(): Int = R.layout.activity_main

    override fun initView() {
    }

    override fun createPresenter(): CommonPresenter = CommonPresenter()

    override fun initDatas() {
        webView = findViewById<View>(R.id.full_web_webview) as X5WebView
        webView.loadUrl(Urls.mMainUrl)

        window.setFormat(PixelFormat.TRANSLUCENT)

        webView.view.overScrollMode = View.OVER_SCROLL_ALWAYS

        presenter.getBanner("")
    }

    override fun getBannerSuccess(data: Any?) {
        if (data is BannerBean) {
            if (data.data?.top != null) {
                if (TextUtils.isEmpty(data.data.top.img_url)) {
                    banner_top.visibility = View.GONE
                    return
                }
                banner_top.visibility = View.VISIBLE
                Glide.with(this).load(data.data.top.img_url).centerCrop().into(banner_top)
                banner_top.setOnClickListener {
                    showAdWebView(data.data.top.url)
                }
            } else {
                banner_top.visibility = View.GONE
            }
            if (data.data?.bottom != null) {
                if (TextUtils.isEmpty(data.data.bottom.img_url)) {
                    banner_bottom.visibility = View.GONE
                    return
                }
                banner_bottom.visibility = View.VISIBLE
                Glide.with(this).load(data.data.bottom.img_url).centerCrop().into(banner_bottom)
                banner_bottom.setOnClickListener { showAdWebView(data.data.bottom.url)}
            } else {
                banner_bottom.visibility = View.GONE
            }
        }
    }

    private fun showAdWebView(url: String?) {
        ad_web_webview.IS_NEED_CLAER = true
        ad_web_webview.loadUrl(url)
        ad_web_webview.visibility = View.VISIBLE
        webView.visibility = View.GONE
    }

    override fun onBackPressed() {
        if (ad_web_webview.isShown) {
            if (ad_web_webview.canGoBack()) {
                ad_web_webview.goBack()
            } else {
                ad_web_webview.IS_NEED_CLAER = true
                ad_web_webview.loadUrl("about:blank")// 清空当前加载
                ad_web_webview.visibility = View.GONE
                webView.visibility = View.VISIBLE
                ad_web_webview.clearHistory()
            }
        } else {
            if (webView.canGoBack()) {
                webView.goBack()
            } else {
                finish()
            }
        }
    }
}
