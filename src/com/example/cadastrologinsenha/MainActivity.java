package com.example.cadastrologinsenha;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText editTextUsername, editTextPassword;
	private Button buttonRegister, buttonLogin;
	private DataManager dataManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editTextUsername = (EditText) findViewById(R.id.editTextUsername);
		editTextPassword = (EditText) findViewById(R.id.editTextPassword);
		buttonRegister = (Button) findViewById(R.id.buttonRegister);
		buttonLogin = (Button) findViewById(R.id.buttonLogin);

		dataManager = new DataManager(this);
		dataManager.open();

		buttonRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				cadastrar();
			}
		});

		buttonLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				autenticar();
			}
		});
	}

	private void cadastrar() {
		String username = editTextUsername.getText().toString();
		String password = editTextPassword.getText().toString();

		long result = dataManager.cadastrarUsuario(username, password);

		if (result != -1) {
			Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
		}
	}

	private void autenticar() {
		String username = editTextUsername.getText().toString();
		String password = editTextPassword.getText().toString();

		boolean authenticated = dataManager.autenticarUsuario(username, password);

		if (authenticated) {
			Toast.makeText(this, "Login bem-sucedido", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "Login falhou", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		dataManager.close();
	}
}
