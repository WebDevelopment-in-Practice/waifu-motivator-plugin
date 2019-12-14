package zd.zero.waifu.motivator.plugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;
import zd.zero.waifu.motivator.plugin.alert.WaifuMotivatorAlert;
import zd.zero.waifu.motivator.plugin.alert.WaifuMotivatorAlertFactory;
import zd.zero.waifu.motivator.plugin.alert.WaifuMotivatorAsset;
import zd.zero.waifu.motivator.plugin.alert.WaifuMotivatorAssetType;
import zd.zero.waifu.motivator.plugin.alert.notification.AlertConfiguration;

public class MotivateMeAction extends AnAction {

    @Override
    public void actionPerformed( @NotNull AnActionEvent e ) {
        AlertConfiguration config = AlertConfiguration.builder()
                .isAlertEnabled( true )
                .isDisplayNotificationEnabled( true )
                .isSoundAlertEnabled( true )
                .build();

        WaifuMotivatorAlert motivatorAlert = WaifuMotivatorAlertFactory.createAlert( e.getProject(),
                WaifuMotivatorAsset.getRandomAssetByType( WaifuMotivatorAssetType.POSITIVE ), config );
        motivatorAlert.alert();
    }

    @Override
    public void update( @NotNull AnActionEvent e ) {
        e.getPresentation().setEnabledAndVisible( e.getProject() != null );
    }
}