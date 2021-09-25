package es.jesuitas.dam.implicitintents

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import es.jesuitas.dam.implicitintents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnWeb.setOnClickListener(this)
        binding.btnWebsearch.setOnClickListener(this)
        binding.btnMap.setOnClickListener(this)
        binding.btnMail.setOnClickListener(this)
        binding.btnPhone.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_web -> openWeb("https://www.jesuitasrioja.org")
            R.id.btn_websearch -> searchWeb("Jesuitas Rioja")
            R.id.btn_map -> openMap("Duques de Nájera 19, Logroño")
            R.id.btn_mail -> sendMail("csc@jesuitasrioja.org")
            R.id.btn_phone -> phoneCall("941221700")
        }
    }

    // https://developer.android.com/guide/components/intents-common?hl=en#Phone
    private fun phoneCall(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    // https://developer.android.com/guide/components/intents-common?hl=en#Email
    private fun sendMail(email: String) {
        val emails: Array<String> = arrayOf(email)
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, emails)
            putExtra(Intent.EXTRA_SUBJECT, "Asunto de Prueba")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    // https://developer.android.com/guide/components/intents-common?hl=en#Maps
    private fun openMap(address: String) {
        val addressUri: Uri = Uri.parse("geo:0,0?q=$address")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }

    }

    // https://developer.android.com/guide/components/intents-common?hl=en#SearchWeb
    private fun searchWeb(query: String) {
        val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
            putExtra(SearchManager.QUERY, query)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    // https://developer.android.com/guide/components/intents-common?hl=en#Browser
    private fun openWeb(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}