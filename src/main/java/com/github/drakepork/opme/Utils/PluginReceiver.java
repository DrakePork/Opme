package com.github.drakepork.opme.Utils;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.github.drakepork.opme.Main;

public class PluginReceiver extends AbstractModule {

	protected final Main plugin;

	public PluginReceiver(Main plugin) {
		this.plugin = plugin;
	}

	public Injector createInjector() {
		return Guice.createInjector(this);
	}

	@Override
	protected void configure() {
		this.bind(Main.class).toInstance(this.plugin);
	}
}
