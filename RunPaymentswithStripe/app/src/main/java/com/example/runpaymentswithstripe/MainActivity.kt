package com.example.runpaymentswithstripe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.billingclient.api.AcknowledgePurchaseParams
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.PurchasesUpdatedListener
import com.android.billingclient.api.SkuDetailsParams

class MainActivity : AppCompatActivity() {

    private lateinit var billingClient: BillingClient
    private val skuList = listOf("product1", "product2")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
//        initView()
        second()
    }

    private fun second() {

        val billingClient = BillingClient.newBuilder(this)
            .setListener { billingResult, purchases ->
                // Handle any changes in purchase state or errors
            }
            .enablePendingPurchases()
            .build()

        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                    // Billing client is ready
                }
            }

            override fun onBillingServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.
            }
        })



        val skuList = listOf("product_id_1", "product_id_2")
        val params = SkuDetailsParams.newBuilder()
            .setType(BillingClient.SkuType.INAPP) // or BillingClient.SkuType.SUBS for subscriptions
            .setSkusList(skuList)
            .build()

        billingClient.querySkuDetailsAsync(params) { billingResult, skuDetailsList ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && skuDetailsList != null) {
                // Display the list of products or subscriptions to the user
            }
        }



//        val skuDetails = skuDetailsList.firstOrNull { it.sku == "product_id_1" }
//        if (skuDetails != null) {
//            val billingFlowParams = BillingFlowParams.newBuilder()
//                .setSkuDetails(skuDetails)
//                .build()


        val billingResult = "null"

        val skuDetailsList = billingResult?.skuDetailsList
        if (skuDetailsList != null && skuDetailsList.isNotEmpty()) {
            val skuDetails = skuDetailsList.firstOrNull { it.sku == "product_id_1" }
            if (skuDetails != null) {
                val billingFlowParams = BillingFlowParams.newBuilder()
                    .setSkuDetails(skuDetails)
                    .build()

            val responseCode = billingClient.launchBillingFlow(this@MainActivity, billingFlowParams)
            if (responseCode.responseCode == BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED) {
                // The user already owns this item, so grant access
            }
        }


        val purchases = billingClient.queryPurchases(BillingClient.SkuType.INAPP).purchasesList
        if (purchases != null && purchases.isNotEmpty()) {
            for (purchase in purchases) {
                if (purchase.purchaseState == Purchase.PurchaseState.PURCHASED) {
                    // Grant access to the purchased product or subscription
                }
            }
        }
















    }
//
//        private val purchaseUpdateListener = PurchasesUpdatedListener { billingResult, purchases ->
//            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && purchases != null) {
//                for (purchase in purchases) {
//                    handlePurchase(purchase)
//                }
//            } else if (billingResult.responseCode == BillingClient.BillingResponseCode.USER_CANCELED) {
//                // Handle user cancelled the purchase flow
//            } else {
//                // Handle other errors
//            }
//        }
//
//
//
//    val skuDetailsParams = SkuDetailsParams.newBuilder()
//        .setType(BillingClient.SkuType.SUBS) // Specify if the item is a subscription or an in-app product
//        .setSkusList(listOf("your_sku_id")) // List of SKUs to query from Google Play
//        .build()
//
//
//
//
//
//    val billingFlowParams = BillingFlowParams.newBuilder()
//        .setSkuDetails(skuDetails)
//        .build()
//
//    val responseCode = billingClient.launchBillingFlow(this@MainActivity, billingFlowParams)
//
//
//    private fun handlePurchase(purchase: Purchase) {
//        // Grant entitlement to the user and acknowledge the purchase
//        val acknowledgePurchaseParams = AcknowledgePurchaseParams.newBuilder()
//            .setPurchaseToken(purchase.purchaseToken)
//            .build()
//
//        billingClient.acknowledgePurchase(acknowledgePurchaseParams) { billingResult ->
//            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
//                // Purchase acknowledged
//            }
//        }
//    }
//
//    private fun initView() {
//
//        val skuDetailsParams = SkuDetailsParams.newBuilder()
//            .setSkusList(skuList)
//            .setType(BillingClient.SkuType.INAPP)
//            .build()
//
//        billingClient.querySkuDetailsAsync(skuDetailsParams) { billingResult, skuDetailsList ->
//            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && skuDetailsList != null) {
//                for (skuDetails in skuDetailsList) {
//                    // Use the retrieved SkuDetails object to display product information
//                }
//            }
//        }
//
//
//
//        billingClient = BillingClient.newBuilder(this)
//            .setListener(purchaseUpdateListener)
//            .enablePendingPurchases()
//            .build()
//
//        billingClient.startConnection(object : BillingClientStateListener {
//            override fun onBillingSetupFinished(billingResult: BillingResult) {
//                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
//                    // Billing client is ready
//                }
//            }
//
//            override fun onBillingServiceDisconnected() {
//                // Try to restart the connection on the next request to
//                // Google Play by calling the startConnection() method.
//            }
//        })
//    }


}



