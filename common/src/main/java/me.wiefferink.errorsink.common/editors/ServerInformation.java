package me.wiefferink.errorsink.common.editors;

import io.sentry.event.EventBuilder;
import me.wiefferink.errorsink.common.ErrorSink;
import me.wiefferink.errorsink.common.EventEditor;
import org.apache.logging.log4j.core.LogEvent;

public class ServerInformation extends EventEditor {

	private String serverVersion;

	public ServerInformation() {
		serverVersion = ErrorSink.getPlugin().getServerVersion();
	}

	@Override
	public void processEvent(EventBuilder builder, LogEvent event) {
		// Server information
		builder.withTag("API", serverVersion);
		builder.withExtra("Online players", ErrorSink.getPlugin().getOnlinePlayers());
		builder.withExtra("Online player details", ErrorSink.getPlugin().getOnlinePlayerLocation());
		ErrorSink.getPlugin().addExtraData(builder);
	}

}
