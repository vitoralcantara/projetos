<?xml version='1.0' encoding='UTF-8'?>
<?profile class='org.eclipse.equinox.internal.p2.engine.Profile' version='0.0.2'?>
<profile id='RodinProfile' timestamp='1273438556310'>
  <properties size='13'>
    <property name='org.eclipse.equinox.p2.installFolder' value='C:\Users\Vitor\Documents\Bolsa CNPQ\rodin-1.1-win32\rodin'/>
    <property name='org.eclipse.equinox.p2.cache' value='C:\Users\Vitor\workspace\.metadata\.plugins\org.eclipse.pde.core'/>
    <property name='org.eclipse.update.install.features' value='true'/>
    <property name='org.eclipse.equinox.p2.roaming' value='false'/>
    <property name='org.eclipse.equinox.p2.flavor' value='tooling'/>
    <property name='org.eclipse.equinox.p2.environments' value='osgi.ws=win32,osgi.os=win32,osgi.arch=x86'/>
    <property name='eclipse.touchpoint.launcherName' value='rodin.exe'/>
    <property name='org.eclipse.equinox.p2.cache.extensions' value='file:/C:/Users/Vitor/Documents/Bolsa CNPQ/rodin-1.1-win32/rodin/.eclipseextension|file:/C:/Users/Vitor/Documents/Bolsa CNPQ/rodin-1.1-win32/rodin/configuration/org.eclipse.osgi/bundles/69/data/listener_1925729951/'/>
    <property name='org.eclipse.equinox.p2.surrogate' value='true'/>
    <property name='org.eclipse.equinox.p2.shared.timestamp' value='1273437974214'/>
    <property name='org.eclipse.equinox.p2.cache.shared' value='C:\Users\Vitor\Documents\Bolsa CNPQ\rodin-1.1-win32\rodin'/>
    <property name='org.eclipse.equinox.p2.configurationFolder' value='C:\Users\Vitor\workspace\.metadata\.plugins\org.eclipse.pde.core\Eclipse Application (1)'/>
    <property name='org.eclipse.equinox.p2.launcherConfiguration' value='C:\Users\Vitor\workspace\.metadata\.plugins\org.eclipse.pde.core\Eclipse Application (1)\eclipse.ini.ignored'/>
  </properties>
  <units size='4'>
    <unit id='org.rodinp.platform.product' version='1.1.0.r7661'>
      <update id='org.rodinp.platform.product' range='0.0.0' severity='0'/>
      <properties size='3'>
        <property name='org.eclipse.equinox.p2.name' value='Rodin Platform'/>
        <property name='lineUp' value='true'/>
        <property name='org.eclipse.equinox.p2.type.group' value='true'/>
      </properties>
      <provides size='1'>
        <provided namespace='org.eclipse.equinox.p2.iu' name='org.rodinp.platform.product' version='1.1.0.r7661'/>
      </provides>
      <requires size='455'>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.help.webapp' range='[3.3.101.M20080805_34x,3.3.101.M20080805_34x]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.apache.commons.logging' range='[1.0.4.v20080605-1930,1.0.4.v20080605-1930]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.artifact.repository' range='[1.0.4.v20080930,1.0.4.v20080930]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.security' range='[1.0.1.R34x_v20080721,1.0.1.R34x_v20080721]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.ide' range='[3.4.2.M20090127-1700,3.4.2.M20090127-1700]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.views' range='[3.3.1.M20081112-0800,3.3.1.M20081112-0800]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.ui' range='[1.0.4.R34x_v20090123,1.0.4.R34x_v20090123]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.updatechecker' range='[1.0.0.v20080427-2136,1.0.0.v20080427-2136]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.security.macosx' range='[1.0.0.v20080602-2000,1.0.0.v20080602-2000]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.filebuffers' range='[3.4.0.v20080603-2000,3.4.0.v20080603-2000]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ecf.ssl' range='[1.0.0.v20080611-1715,1.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.workbench.texteditor' range='[3.4.1.r341_v20080827-1100,3.4.1.r341_v20080827-1100]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.osgi' range='[3.4.3.R34x_v20081215-1030,3.4.3.R34x_v20081215-1030]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.jobs' range='[3.4.1.R34x_v20081128,3.4.1.R34x_v20081128]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.commands' range='[3.4.0.I20080509-2000,3.4.0.I20080509-2000]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.updatesite' range='[1.0.1.R34x_v20080808-1156,1.0.1.R34x_v20080808-1156]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.director.app' range='[1.0.1.R34x_v20080729,1.0.1.R34x_v20080729]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.update.core.linux' range='[3.2.1.R34x_v20081024,3.2.1.R34x_v20081024]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.update.core' range='[3.2.202.R34x_v20081128,3.2.202.R34x_v20081128]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ltk.ui.refactoring' range='[3.4.1.r341_v20080716-0800,3.4.1.r341_v20080716-0800]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.intro' range='[3.2.201.v20080702_34x,3.2.201.v20080702_34x]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.help' range='[3.3.102.v20081014_34x,3.3.102.v20081014_34x]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.net.linux.x86' range='[1.0.0.I20080521,1.0.0.I20080521]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eventb.ui.symboltable' range='[1.0.0,1.0.0]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.extensionlocation' range='[1.0.4.v20081027-2115,1.0.4.v20081027-2115]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86javax.servlet' range='[2.4.0.v200806031604,2.4.0.v200806031604]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eventb.ide' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86javax.servlet' range='[2.4.0.v200806031604,2.4.0.v200806031604]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.rcp' range='[3.4.1.R342_v20090205,3.4.1.R342_v20090205]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.workbench.compatibility' range='[3.2.0.I20080509-2000,3.2.0.I20080509-2000]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.rodinp' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eventb.ui' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingorg.rodinp.platform.product.launcher.win32.win32.x86' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.extensionlocation' range='[1.0.4.v20081027-2115,1.0.4.v20081027-2115]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.jsch.core' range='[1.1.100.I20080604,1.1.100.I20080604]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eventb.core.seqprover' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.boot' range='[3.1.100.v20080218,3.1.100.v20080218]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.http.jetty' range='[1.1.0.v20080425,1.1.0.v20080425]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.artifact.repository' range='[1.0.4.v20080930,1.0.4.v20080930]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.views' range='[3.3.1.M20081112-0800,3.3.1.M20081112-0800]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.runtime' range='[3.4.0.v20080512,3.4.0.v20080512]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcjavax.servlet.jsp' range='[2.0.0.v200806031607,2.0.0.v200806031607]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.forms' range='[3.3.103.v20081027_34x,3.3.103.v20081027_34x]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.team.core' range='[3.4.2.r34x_20080115,3.4.2.r34x_20080115]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.rodinp.platform' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eventb.core.ast' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.cheatsheets' range='[3.3.101.v20080702_34x,3.3.101.v20080702_34x]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.director' range='[1.0.4.v20081112-1019,1.0.4.v20081112-1019]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcch.ethz.eventb.keyboard.latex' range='[1.0.0.r7661,1.0.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eventb.ui.symboltable' range='[1.0.0,1.0.0]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.jsp.jasper' range='[1.0.100.v20080427-0830,1.0.100.v20080427-0830]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.apache.ant' range='[1.7.0.v200803061910,1.7.0.v200803061910]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.common' range='[3.4.0.v20080421-2006,3.4.0.v20080421-2006]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.http.servlet' range='[1.0.100.v20080427-0830,1.0.100.v20080427-0830]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.ui.sdk' range='[1.0.1.R34x_v20081029,1.0.1.R34x_v20081029]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.app' range='[1.1.0.v20080421-2006,1.1.0.v20080421-2006]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.updatesite' range='[1.0.1.R34x_v20080808-1156,1.0.1.R34x_v20080808-1156]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.workbench' range='[3.4.2.M20090127-1700,3.4.2.M20090127-1700]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.core' range='[1.0.4.v20081112-1019,1.0.4.v20081112-1019]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86com.jcraft.jsch' range='[0.1.37.v200803061811,0.1.37.v200803061811]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.osgi.services' range='[3.1.200.v20071203,3.1.200.v20071203]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.carbon' range='[4.0.0.I20080610-1200,4.0.0.I20080610-1200]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.swt' range='[3.4.2.v3452b,3.4.2.v3452b]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ecf.ssl' range='[1.0.0.v20080611-1715,1.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='org.rodinp.platform.feature.group' range='[1.1.0.r7661,1.1.0.r7661]'/>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.jsp.jasper.registry' range='[1.0.0.v20080427-0830,1.0.0.v20080427-0830]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.update.core' range='[3.2.202.R34x_v20081128,3.2.202.R34x_v20081128]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.simpleconfigurator.manipulator' range='[1.0.4.v20080930,1.0.4.v20080930]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.platform' range='[3.3.101.v200902111700,3.3.101.v200902111700]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.ide.application' range='[1.0.1.M20090204-0800,1.0.1.M20090204-0800]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.jsp.jasper.registry' range='[1.0.0.v20080427-0830,1.0.0.v20080427-0830]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.runtime.compatibility' range='[3.2.0.v20071008,3.2.0.v20071008]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.apache.lucene' range='[1.9.1.v20080530-1600,1.9.1.v20080530-1600]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ltk.core.refactoring' range='[3.4.2.r342_v20081028-0800,3.4.2.r342_v20081028-0800]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.touchpoint.natives' range='[1.0.0.v20080505-1850,1.0.0.v20080505-1850]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.text' range='[3.4.0.v20080605-1800,3.4.0.v20080605-1800]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.help.appserver' range='[3.1.300.v20080507,3.1.300.v20080507]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.metadata.generator' range='[1.0.4.v20081217,1.0.4.v20081217]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.updatesite' range='[1.0.1.R34x_v20080808-1156,1.0.1.R34x_v20080808-1156]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.update.ui' range='[3.2.101.R34x_v20081128,3.2.101.R34x_v20081128]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui' range='[3.4.2.M20090204-0800,3.4.2.M20090204-0800]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.intro.universal' range='[3.2.200.v20080508,3.2.200.v20080508]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.swt.gtk.linux.x86' range='[3.4.1.v3452b,3.4.1.v3452b]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.databinding.beans' range='[1.1.1.M20080827-0800a,1.1.1.M20080827-0800a]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.help.appserver' range='[3.1.300.v20080507,3.1.300.v20080507]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.directorywatcher' range='[1.0.2.v20080806-1619,1.0.2.v20080806-1619]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.security.win32.x86' range='[1.0.0.v20080529-1600,1.0.0.v20080529-1600]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.http.servlet' range='[1.0.100.v20080427-0830,1.0.100.v20080427-0830]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.common' range='[3.4.0.v20080421-2006,3.4.0.v20080421-2006]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.apache.jasper' range='[5.5.17.v200806031609,5.5.17.v200806031609]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.registry' range='[3.4.0.v20080516-0950,3.4.0.v20080516-0950]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.ide' range='[3.4.2.M20090127-1700,3.4.2.M20090127-1700]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.http.jetty' range='[1.1.0.v20080425,1.1.0.v20080425]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.frameworkadmin' range='[1.0.2.R34x_v20081007,1.0.2.R34x_v20081007]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eventb.core' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.resources.compatibility' range='[3.4.0.v20080604-1400,3.4.0.v20080604-1400]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86ch.ethz.eventb.keyboard.latex' range='[1.0.0.r7661,1.0.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.director.app' range='[1.0.1.R34x_v20080729,1.0.1.R34x_v20080729]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.jarprocessor' range='[1.0.0.v20080514-1900,1.0.0.v20080514-1900]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.workbench.texteditor' range='[3.4.1.r341_v20080827-1100,3.4.1.r341_v20080827-1100]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.apache.jasper' range='[5.5.17.v200806031609,5.5.17.v200806031609]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.team.core' range='[3.4.2.r34x_20080115,3.4.2.r34x_20080115]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.databinding' range='[1.1.1.M20080827-0800b,1.1.1.M20080827-0800b]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eventb.pp.ui' range='[0.1.1.r7661,0.1.1.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ltk.core.refactoring' range='[3.4.2.r342_v20081028-0800,3.4.2.r342_v20081028-0800]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.console' range='[3.3.1.v20090128_r342,3.3.1.v20090128_r342]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eventb.pptrans' range='[0.3.0.r7661,0.3.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ecf' range='[2.0.0.v20080611-1715,2.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eventb.pptrans' range='[0.3.0.r7661,0.3.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.swt.win32.win32.x86' range='[3.4.1.v3452b,3.4.1.v3452b]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.rodinp.platform' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.views.properties.tabbed' range='[3.4.2.M20090127-1700,3.4.2.M20090127-1700]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ecf.filetransfer' range='[2.0.0.v20080611-1715,2.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ecf.ssl' range='[1.0.0.v20080611-1715,1.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.rodinp' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.jsch.core' range='[1.1.100.I20080604,1.1.100.I20080604]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.console' range='[1.0.0.v20080514-1900,1.0.0.v20080514-1900]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.team.ui' range='[3.4.1.r34x_20080827,3.4.1.r34x_20080827]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.ide.application' range='[1.0.1.M20090204-0800,1.0.1.M20090204-0800]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.runtime.compatibility.registry' range='[3.2.200.v20080610,3.2.200.v20080610]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.net' range='[1.1.0.I20080604,1.1.0.I20080604]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.rcp' range='[3.4.1.R342_v20090205,3.4.1.R342_v20090205]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ecf.identity' range='[2.0.0.v20080611-1715,2.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppccom.jcraft.jsch' range='[0.1.37.v200803061811,0.1.37.v200803061811]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.jsp.jasper.registry' range='[1.0.0.v20080427-0830,1.0.0.v20080427-0830]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.filesystem.macosx' range='[1.0.0.v20080604-1400,1.0.0.v20080604-1400]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.core' range='[1.0.4.v20081112-1019,1.0.4.v20081112-1019]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.garbagecollector' range='[1.0.1.R34x_v20080818,1.0.1.R34x_v20080818]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eventb.core' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.security' range='[1.0.1.R34x_v20080721,1.0.1.R34x_v20080721]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.resources' range='[3.4.2.R34x_v20090126,3.4.2.R34x_v20090126]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.jsch.core' range='[1.1.100.I20080604,1.1.100.I20080604]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.runtime.compatibility.auth' range='[3.2.100.v20070502,3.2.100.v20070502]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.garbagecollector' range='[1.0.1.R34x_v20080818,1.0.1.R34x_v20080818]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingorg.eclipse.equinox.launcher.win32.win32.x86' range='[1.0.101.R34x_v20080731,1.0.101.R34x_v20080731]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.jface.text' range='[3.4.2.r342_v20081119-0800,3.4.2.r342_v20081119-0800]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.commands' range='[3.4.0.I20080509-2000,3.4.0.I20080509-2000]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.simpleconfigurator' range='[1.0.0.v20080604,1.0.0.v20080604]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.runtime.compatibility.auth' range='[3.2.100.v20070502,3.2.100.v20070502]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.variables' range='[3.2.100.v20080529-1300,3.2.100.v20080529-1300]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.osgi.services' range='[3.1.200.v20071203,3.1.200.v20071203]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.platform.doc.user' range='[3.4.2.r342_v20081031-0800,3.4.2.r342_v20081031-0800]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86javax.servlet.jsp' range='[2.0.0.v200806031607,2.0.0.v200806031607]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.app' range='[1.1.0.v20080421-2006,1.1.0.v20080421-2006]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eventb.eventBKeyboard' range='[2.9.0.r7661,2.9.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.workbench' range='[3.4.2.M20090127-1700,3.4.2.M20090127-1700]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.update.configurator' range='[3.2.201.R34x_v20080819,3.2.201.R34x_v20080819]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcjavax.servlet' range='[2.4.0.v200806031604,2.4.0.v200806031604]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.console' range='[1.0.0.v20080514-1900,1.0.0.v20080514-1900]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.rodinp.keyboard' range='[1.0.0.r7661,1.0.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.frameworkadmin' range='[1.0.2.R34x_v20081007,1.0.2.R34x_v20081007]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.osgi.util' range='[3.1.300.v20080303,3.1.300.v20080303]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ant.core' range='[3.2.0.v20080529,3.2.0.v20080529]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.osgi.util' range='[3.1.300.v20080303,3.1.300.v20080303]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.update.scheduler' range='[3.2.100.v20080404,3.2.100.v20080404]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.net' range='[1.1.0.I20080604,1.1.0.I20080604]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.help.ui' range='[3.3.102.v20081014_34x,3.3.102.v20081014_34x]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.help.ui' range='[3.3.102.v20081014_34x,3.3.102.v20081014_34x]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.navigator.resources' range='[3.3.101.M20080910-0800,3.3.101.M20080910-0800]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86javax.servlet.jsp' range='[2.0.0.v200806031607,2.0.0.v200806031607]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.touchpoint.natives' range='[1.0.0.v20080505-1850,1.0.0.v20080505-1850]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.intro.universal' range='[3.2.200.v20080508,3.2.200.v20080508]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.metadata.repository' range='[1.0.0.v20080604,1.0.0.v20080604]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eventb.eventBKeyboard' range='[2.9.0.r7661,2.9.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eventb.ui' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.rodinp.core' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.debug.core' range='[3.4.1.v20090106_r342,3.4.1.v20090106_r342]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.apache.ant' range='[1.7.0.v200803061910,1.7.0.v200803061910]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingorg.eclipse.equinox.p2.reconciler.dropins' range='[1.0.4.v20081027-2115,1.0.4.v20081027-2115]'/>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.jarprocessor' range='[1.0.0.v20080514-1900,1.0.0.v20080514-1900]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eventb.pptrans' range='[0.3.0.r7661,0.3.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.jsp.jasper' range='[1.0.100.v20080427-0830,1.0.100.v20080427-0830]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eventb.pp.ui' range='[0.1.1.r7661,0.1.1.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.console' range='[3.3.1.v20090128_r342,3.3.1.v20090128_r342]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.osgi.services' range='[3.1.200.v20071203,3.1.200.v20071203]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ltk.core.refactoring' range='[3.4.2.r342_v20081028-0800,3.4.2.r342_v20081028-0800]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.team.ui' range='[3.4.1.r34x_20080827,3.4.1.r34x_20080827]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.databinding' range='[1.1.1.M20080827-0800b,1.1.1.M20080827-0800b]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.jarprocessor' range='[1.0.0.v20080514-1900,1.0.0.v20080514-1900]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.workbench.texteditor' range='[3.4.1.r341_v20080827-1100,3.4.1.r341_v20080827-1100]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ant.core' range='[3.2.0.v20080529,3.2.0.v20080529]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.editors' range='[3.4.0.v20080603-2000,3.4.0.v20080603-2000]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.metadata.repository' range='[1.0.0.v20080604,1.0.0.v20080604]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.apache.jasper' range='[5.5.17.v200806031609,5.5.17.v200806031609]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eventb.keyboard' range='[1.0.0.r7661,1.0.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.engine' range='[1.0.4.v20080930,1.0.4.v20080930]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.metadata' range='[1.0.0.v20080514-1900,1.0.0.v20080514-1900]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.net' range='[1.0.0.I20080605,1.0.0.I20080605]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingorg.eclipse.equinox.launcher.gtk.linux.x86' range='[1.0.101.R34x_v20080805,1.0.101.R34x_v20080805]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.help.webapp' range='[3.3.101.M20080805_34x,3.3.101.M20080805_34x]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.update.configurator' range='[3.2.201.R34x_v20080819,3.2.201.R34x_v20080819]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.http.registry' range='[1.0.100.v20080427-0830,1.0.100.v20080427-0830]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.frameworkadmin.equinox' range='[1.0.4.v20080930,1.0.4.v20080930]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.directorywatcher' range='[1.0.2.v20080806-1619,1.0.2.v20080806-1619]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcfr.systerel.explorer' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingorg.eclipse.equinox.launcher' range='[1.0.101.R34x_v20081125,1.0.101.R34x_v20081125]'/>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.preferences' range='[3.2.201.R34x_v20080709,3.2.201.R34x_v20080709]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingorg.eclipse.equinox.launcher.carbon.macosx' range='[1.0.101.R34x_v20080731,1.0.101.R34x_v20080731]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (|(osgi.arch=x86)(osgi.arch=ppc)) )
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.jface' range='[3.4.2.M20090107-0800,3.4.2.M20090107-0800]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.ide.application' range='[1.0.1.M20090204-0800,1.0.1.M20090204-0800]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.resources.compatibility' range='[3.4.0.v20080604-1400,3.4.0.v20080604-1400]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.apache.lucene.analysis' range='[1.9.1.v20080530-1600,1.9.1.v20080530-1600]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.sat4j.core' range='[2.0.3.v20081021,2.0.3.v20081021]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eventb.pp' range='[0.3.0.r7661,0.3.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.touchpoint.eclipse' range='[1.0.2.v20081119-1055,1.0.2.v20081119-1055]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.director' range='[1.0.4.v20081112-1019,1.0.4.v20081112-1019]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.common' range='[3.4.0.v20080421-2006,3.4.0.v20080421-2006]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ecf' range='[2.0.0.v20080611-1715,2.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.net.win32.x86' range='[1.0.0.I20080521,1.0.0.I20080521]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.help.base' range='[3.3.103.v20090128_34x,3.3.103.v20090128_34x]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.osgi' range='[3.4.3.R34x_v20081215-1030,3.4.3.R34x_v20081215-1030]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.simpleconfigurator' range='[1.0.0.v20080604,1.0.0.v20080604]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86com.ibm.icu' range='[3.8.1.v20080530,3.8.1.v20080530]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.extensionlocation' range='[1.0.4.v20081027-2115,1.0.4.v20081027-2115]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.search' range='[3.4.1.r341_v20080813-0800,3.4.1.r341_v20080813-0800]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.debug.core' range='[3.4.1.v20090106_r342,3.4.1.v20090106_r342]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.jobs' range='[3.4.1.R34x_v20081128,3.4.1.R34x_v20081128]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ecf.filetransfer' range='[2.0.0.v20080611-1715,2.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ltk.ui.refactoring' range='[3.4.1.r341_v20080716-0800,3.4.1.r341_v20080716-0800]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.externaltools' range='[3.2.0.v20080514-1542,3.2.0.v20080514-1542]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.filesystem.linux.x86' range='[1.2.0.v20080604-1400,1.2.0.v20080604-1400]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.app' range='[1.1.0.v20080421-2006,1.1.0.v20080421-2006]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.runtime.compatibility' range='[3.2.0.v20071008,3.2.0.v20071008]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.artifact.repository' range='[1.0.4.v20080930,1.0.4.v20080930]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.frameworkadmin.equinox' range='[1.0.4.v20080930,1.0.4.v20080930]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.metadata' range='[1.0.0.v20080514-1900,1.0.0.v20080514-1900]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eventb.keyboard' range='[1.0.0.r7661,1.0.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.sat4j.core' range='[2.0.3.v20081021,2.0.3.v20081021]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.frameworkadmin' range='[1.0.2.R34x_v20081007,1.0.2.R34x_v20081007]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.jsch.ui' range='[1.1.100.I20080415,1.1.100.I20080415]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='org.eclipse.equinox.launcher' range='[1.0.101.R34x_v20081125,1.0.101.R34x_v20081125]'/>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eventb.pp' range='[0.3.0.r7661,0.3.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.navigator' range='[3.3.102.M20090127-1700,3.3.102.M20090127-1700]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.expressions' range='[3.4.1.r342_v20081203-0800,3.4.1.r342_v20081203-0800]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.rodinp.keyboard' range='[1.0.0.r7661,1.0.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.http.servlet' range='[1.0.100.v20080427-0830,1.0.100.v20080427-0830]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.help.ui' range='[3.3.102.v20081014_34x,3.3.102.v20081014_34x]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.text' range='[3.4.0.v20080605-1800,3.4.0.v20080605-1800]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.externaltools' range='[3.2.0.v20080514-1542,3.2.0.v20080514-1542]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.sat4j.pb' range='[2.0.3.v20081021,2.0.3.v20081021]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.apache.ant' range='[1.7.0.v200803061910,1.7.0.v200803061910]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.apache.commons.el' range='[1.0.0.v200806031608,1.0.0.v200806031608]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eventb.ui.symboltable' range='[1.0.0,1.0.0]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.rodinp.keyboard' range='[1.0.0.r7661,1.0.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.forms' range='[3.3.103.v20081027_34x,3.3.103.v20081027_34x]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.metadata' range='[1.0.0.v20080514-1900,1.0.0.v20080514-1900]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.platform.doc.user' range='[3.4.2.r342_v20081031-0800,3.4.2.r342_v20081031-0800]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.filebuffers' range='[3.4.0.v20080603-2000,3.4.0.v20080603-2000]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.boot' range='[3.1.100.v20080218,3.1.100.v20080218]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.help.base' range='[3.3.103.v20090128_34x,3.3.103.v20090128_34x]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ecf.identity' range='[2.0.0.v20080611-1715,2.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.simpleconfigurator.manipulator' range='[1.0.4.v20080930,1.0.4.v20080930]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.resources.compatibility' range='[3.4.0.v20080604-1400,3.4.0.v20080604-1400]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ecf.provider.filetransfer.ssl' range='[1.0.0.v20080611-1715,1.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.sat4j.pb' range='[2.0.3.v20081021,2.0.3.v20081021]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.views.properties.tabbed' range='[3.4.2.M20090127-1700,3.4.2.M20090127-1700]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.preferences' range='[3.2.201.R34x_v20080709,3.2.201.R34x_v20080709]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.jface.databinding' range='[1.2.1.M20080827-0800a,1.2.1.M20080827-0800a]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.swt.carbon.macosx' range='[3.4.1.v3452b,3.4.1.v3452b]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.jface' range='[3.4.2.M20090107-0800,3.4.2.M20090107-0800]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.updatechecker' range='[1.0.0.v20080427-2136,1.0.0.v20080427-2136]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.update.scheduler' range='[3.2.100.v20080404,3.2.100.v20080404]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.apache.commons.el' range='[1.0.0.v200806031608,1.0.0.v200806031608]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.externaltools' range='[3.2.0.v20080514-1542,3.2.0.v20080514-1542]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.osgi' range='[3.4.3.R34x_v20081215-1030,3.4.3.R34x_v20081215-1030]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.apache.commons.logging' range='[1.0.4.v20080605-1930,1.0.4.v20080605-1930]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.views' range='[3.3.1.M20081112-0800,3.3.1.M20081112-0800]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eventb.ui' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eventb.core.seqprover' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.contenttype' range='[3.3.0.v20080604-1400,3.3.0.v20080604-1400]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.metadata.repository' range='[1.0.0.v20080604,1.0.0.v20080604]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.ide' range='[3.4.2.M20090127-1700,3.4.2.M20090127-1700]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.jobs' range='[3.4.1.R34x_v20081128,3.4.1.R34x_v20081128]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.intro' range='[3.2.201.v20080702_34x,3.2.201.v20080702_34x]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.contenttype' range='[3.3.0.v20080604-1400,3.3.0.v20080604-1400]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.osgi.util' range='[3.1.300.v20080303,3.1.300.v20080303]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.runtime.compatibility.auth' range='[3.2.100.v20070502,3.2.100.v20070502]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.http.registry' range='[1.0.100.v20080427-0830,1.0.100.v20080427-0830]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.navigator' range='[3.3.102.M20090127-1700,3.3.102.M20090127-1700]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.navigator.resources' range='[3.3.101.M20080910-0800,3.3.101.M20080910-0800]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.registry' range='[3.4.0.v20080516-0950,3.4.0.v20080516-0950]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppccom.ibm.icu' range='[3.8.1.v20080530,3.8.1.v20080530]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.browser' range='[3.2.201.v20080708_34x,3.2.201.v20080708_34x]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ecf.provider.filetransfer.ssl' range='[1.0.0.v20080611-1715,1.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.frameworkadmin.equinox' range='[1.0.4.v20080930,1.0.4.v20080930]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86fr.systerel.explorer' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ltk.ui.refactoring' range='[3.4.1.r341_v20080716-0800,3.4.1.r341_v20080716-0800]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.boot' range='[3.1.100.v20080218,3.1.100.v20080218]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.runtime' range='[3.4.0.v20080512,3.4.0.v20080512]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.expressions' range='[3.4.1.r342_v20081203-0800,3.4.1.r342_v20081203-0800]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.director' range='[1.0.4.v20081112-1019,1.0.4.v20081112-1019]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eventb.pp.ui' range='[0.1.1.r7661,0.1.1.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ecf.provider.filetransfer' range='[2.0.0.v20080611-1715,2.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eventb.ide' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.mortbay.jetty' range='[5.1.14.v200806031611,5.1.14.v200806031611]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86com.ibm.icu' range='[3.8.1.v20080530,3.8.1.v20080530]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.core' range='[1.0.4.v20081112-1019,1.0.4.v20081112-1019]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.update.core' range='[3.2.202.R34x_v20081128,3.2.202.R34x_v20081128]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.workbench.compatibility' range='[3.2.0.I20080509-2000,3.2.0.I20080509-2000]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.compare' range='[3.4.1.r34x_20090121,3.4.1.r34x_20090121]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.apache.lucene.analysis' range='[1.9.1.v20080530-1600,1.9.1.v20080530-1600]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.editors' range='[3.4.0.v20080603-2000,3.4.0.v20080603-2000]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.swt' range='[3.4.2.v3452b,3.4.2.v3452b]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.debug.ui' range='[3.4.2.v20090110_r342,3.4.2.v20090110_r342]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.net' range='[1.0.0.I20080605,1.0.0.I20080605]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eventb.core.ast' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.metadata.generator' range='[1.0.4.v20081217,1.0.4.v20081217]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.update.core.win32' range='[3.2.100.v20080107,3.2.100.v20080107]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.debug.ui' range='[3.4.2.v20090110_r342,3.4.2.v20090110_r342]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.search' range='[3.4.1.r341_v20080813-0800,3.4.1.r341_v20080813-0800]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.swt' range='[3.4.2.v3452b,3.4.2.v3452b]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.presentations.r21' range='[3.2.100.I20080512-2000,3.2.100.I20080512-2000]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86ch.ethz.eventb.keyboard.latex' range='[1.0.0.r7661,1.0.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.commands' range='[3.4.0.I20080509-2000,3.4.0.I20080509-2000]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.update.scheduler' range='[3.2.100.v20080404,3.2.100.v20080404]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.jface.databinding' range='[1.2.1.M20080827-0800a,1.2.1.M20080827-0800a]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.touchpoint.eclipse' range='[1.0.2.v20081119-1055,1.0.2.v20081119-1055]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.cheatsheets' range='[3.3.101.v20080702_34x,3.3.101.v20080702_34x]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.help.webapp' range='[3.3.101.M20080805_34x,3.3.101.M20080805_34x]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.help.appserver' range='[3.1.300.v20080507,3.1.300.v20080507]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.reconciler.dropins' range='[1.0.4.v20081027-2115,1.0.4.v20081027-2115]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.rodinp' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ecf' range='[2.0.0.v20080611-1715,2.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.contenttype' range='[3.3.0.v20080604-1400,3.3.0.v20080604-1400]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.rodinp.platform' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.help' range='[3.3.102.v20081014_34x,3.3.102.v20081014_34x]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingorg.rodinp.platform.product.launcher.carbon.macosx.ppc' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eventb.ide' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ecf.provider.filetransfer' range='[2.0.0.v20080611-1715,2.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eventb.keyboard' range='[1.0.0.r7661,1.0.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.editors' range='[3.4.0.v20080603-2000,3.4.0.v20080603-2000]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.jsch.ui' range='[1.1.100.I20080415,1.1.100.I20080415]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.security.ui' range='[1.0.0.v20080603-1810,1.0.0.v20080603-1810]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ecf.identity' range='[2.0.0.v20080611-1715,2.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='org.eventb.ide.feature.group' range='[1.1.0.r7661,1.1.0.r7661]'/>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.sat4j.core' range='[2.0.3.v20081021,2.0.3.v20081021]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.security.ui' range='[1.0.0.v20080603-1810,1.0.0.v20080603-1810]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.jsp.jasper' range='[1.0.100.v20080427-0830,1.0.100.v20080427-0830]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.navigator.resources' range='[3.3.101.M20080910-0800,3.3.101.M20080910-0800]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.exemplarysetup' range='[1.0.0.v20080427-2136,1.0.0.v20080427-2136]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.console' range='[1.0.0.v20080514-1900,1.0.0.v20080514-1900]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.text' range='[3.4.0.v20080605-1800,3.4.0.v20080605-1800]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.help' range='[3.3.102.v20081014_34x,3.3.102.v20081014_34x]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.filesystem' range='[1.2.0.v20080604-1400,1.2.0.v20080604-1400]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.browser' range='[3.2.201.v20080708_34x,3.2.201.v20080708_34x]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.debug.ui' range='[3.4.2.v20090110_r342,3.4.2.v20090110_r342]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.compare' range='[3.4.1.r34x_20090121,3.4.1.r34x_20090121]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.resources' range='[3.4.2.R34x_v20090126,3.4.2.R34x_v20090126]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.workbench' range='[3.4.2.M20090127-1700,3.4.2.M20090127-1700]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.apache.lucene' range='[1.9.1.v20080530-1600,1.9.1.v20080530-1600]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.http.registry' range='[1.0.100.v20080427-0830,1.0.100.v20080427-0830]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.jface' range='[3.4.2.M20090107-0800,3.4.2.M20090107-0800]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.browser' range='[3.2.201.v20080708_34x,3.2.201.v20080708_34x]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.engine' range='[1.0.4.v20080930,1.0.4.v20080930]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86fr.systerel.explorer' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.cheatsheets' range='[3.3.101.v20080702_34x,3.3.101.v20080702_34x]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.reconciler.dropins' range='[1.0.4.v20081027-2115,1.0.4.v20081027-2115]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.resources' range='[3.4.2.R34x_v20090126,3.4.2.R34x_v20090126]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.updatechecker' range='[1.0.0.v20080427-2136,1.0.0.v20080427-2136]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.touchpoint.eclipse' range='[1.0.2.v20081119-1055,1.0.2.v20081119-1055]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ecf.provider.filetransfer.ssl' range='[1.0.0.v20080611-1715,1.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.ui' range='[1.0.4.R34x_v20090123,1.0.4.R34x_v20090123]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.workbench.compatibility' range='[3.2.0.I20080509-2000,3.2.0.I20080509-2000]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.update.ui' range='[3.2.101.R34x_v20081128,3.2.101.R34x_v20081128]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.preferences' range='[3.2.201.R34x_v20080709,3.2.201.R34x_v20080709]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.security' range='[1.0.1.R34x_v20080721,1.0.1.R34x_v20080721]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.directorywatcher' range='[1.0.2.v20080806-1619,1.0.2.v20080806-1619]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingorg.rodinp.platform.product.launcher.gtk.linux.x86' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.rodinp.core' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.platform' range='[3.3.101.v200902111700,3.3.101.v200902111700]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.expressions' range='[3.4.1.r342_v20081203-0800,3.4.1.r342_v20081203-0800]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.runtime' range='[3.4.0.v20080512,3.4.0.v20080512]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ecf.filetransfer' range='[2.0.0.v20080611-1715,2.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.databinding.beans' range='[1.1.1.M20080827-0800a,1.1.1.M20080827-0800a]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.help.base' range='[3.3.103.v20090128_34x,3.3.103.v20090128_34x]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ant.core' range='[3.2.0.v20080529,3.2.0.v20080529]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.net' range='[1.1.0.I20080604,1.1.0.I20080604]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.platform' range='[3.3.101.v200902111700,3.3.101.v200902111700]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.apache.commons.el' range='[1.0.0.v200806031608,1.0.0.v200806031608]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.filebuffers' range='[3.4.0.v20080603-2000,3.4.0.v20080603-2000]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.rcp' range='[3.4.1.R342_v20090205,3.4.1.R342_v20090205]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.databinding' range='[1.1.1.M20080827-0800b,1.1.1.M20080827-0800b]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.forms' range='[3.3.103.v20081027_34x,3.3.103.v20081027_34x]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.filesystem' range='[1.2.0.v20080604-1400,1.2.0.v20080604-1400]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.simpleconfigurator.manipulator' range='[1.0.4.v20080930,1.0.4.v20080930]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui' range='[3.4.2.M20090204-0800,3.4.2.M20090204-0800]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.net' range='[1.0.0.I20080605,1.0.0.I20080605]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eventb.core' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.win32' range='[3.2.100.v20080408-0800,3.2.100.v20080408-0800]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.platform.doc.user' range='[3.4.2.r342_v20081031-0800,3.4.2.r342_v20081031-0800]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.team.core' range='[3.4.2.r34x_20080115,3.4.2.r34x_20080115]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.jface.text' range='[3.4.2.r342_v20081119-0800,3.4.2.r342_v20081119-0800]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ecf.provider.filetransfer' range='[2.0.0.v20080611-1715,2.0.0.v20080611-1715]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.views.properties.tabbed' range='[3.4.2.M20090127-1700,3.4.2.M20090127-1700]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.runtime.compatibility.registry' range='[3.2.200.v20080610,3.2.200.v20080610]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.team.ui' range='[3.4.1.r34x_20080827,3.4.1.r34x_20080827]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.exemplarysetup' range='[1.0.0.v20080427-2136,1.0.0.v20080427-2136]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.runtime.compatibility.registry' range='[3.2.200.v20080610,3.2.200.v20080610]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.simpleconfigurator' range='[1.0.0.v20080604,1.0.0.v20080604]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eventb.pp' range='[0.3.0.r7661,0.3.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.variables' range='[3.2.100.v20080529-1300,3.2.100.v20080529-1300]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.navigator' range='[3.3.102.M20090127-1700,3.3.102.M20090127-1700]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.engine' range='[1.0.4.v20080930,1.0.4.v20080930]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.mortbay.jetty' range='[5.1.14.v200806031611,5.1.14.v200806031611]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.resources.win32.x86' range='[3.4.0.v20071204,3.4.0.v20071204]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui' range='[3.4.2.M20090204-0800,3.4.2.M20090204-0800]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.debug.core' range='[3.4.1.v20090106_r342,3.4.1.v20090106_r342]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eventb.core.seqprover' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eventb.core.ast' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.apache.commons.logging' range='[1.0.4.v20080605-1930,1.0.4.v20080605-1930]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.rodinp.core' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86com.jcraft.jsch' range='[0.1.37.v200803061811,0.1.37.v200803061811]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.jface.text' range='[3.4.2.r342_v20081119-0800,3.4.2.r342_v20081119-0800]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.databinding.beans' range='[1.1.1.M20080827-0800a,1.1.1.M20080827-0800a]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.registry' range='[3.4.0.v20080516-0950,3.4.0.v20080516-0950]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.ui.presentations.r21' range='[3.2.100.I20080512-2000,3.2.100.I20080512-2000]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.filesystem' range='[1.2.0.v20080604-1400,1.2.0.v20080604-1400]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.security.ui' range='[1.0.0.v20080603-1810,1.0.0.v20080603-1810]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.director.app' range='[1.0.1.R34x_v20080729,1.0.1.R34x_v20080729]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.metadata.generator' range='[1.0.4.v20081217,1.0.4.v20081217]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.ui' range='[1.0.4.R34x_v20090123,1.0.4.R34x_v20090123]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.core.runtime.compatibility' range='[3.2.0.v20071008,3.2.0.v20071008]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.apache.lucene.analysis' range='[1.9.1.v20080530-1600,1.9.1.v20080530-1600]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.ui.sdk' range='[1.0.1.R34x_v20081029,1.0.1.R34x_v20081029]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.core.variables' range='[3.2.100.v20080529-1300,3.2.100.v20080529-1300]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.equinox.p2.exemplarysetup' range='[1.0.0.v20080427-2136,1.0.0.v20080427-2136]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.intro.universal' range='[3.2.200.v20080508,3.2.200.v20080508]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.ui.sdk' range='[1.0.1.R34x_v20081029,1.0.1.R34x_v20081029]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.search' range='[3.4.1.r341_v20080813-0800,3.4.1.r341_v20080813-0800]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.update.configurator' range='[3.2.201.R34x_v20080819,3.2.201.R34x_v20080819]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.jsch.ui' range='[1.1.100.I20080415,1.1.100.I20080415]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.http.jetty' range='[1.1.0.v20080425,1.1.0.v20080425]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.update.ui' range='[3.2.101.R34x_v20081128,3.2.101.R34x_v20081128]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.apache.lucene' range='[1.9.1.v20080530-1600,1.9.1.v20080530-1600]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='org.rodinp.platform.product.launcher.win32.win32.x86.rodin.exe' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.os=win32)(osgi.ws=win32)(osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eventb.eventBKeyboard' range='[2.9.0.r7661,2.9.0.r7661]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.garbagecollector' range='[1.0.1.R34x_v20080818,1.0.1.R34x_v20080818]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.equinox.p2.reconciler.dropins' range='[1.0.4.v20081027-2115,1.0.4.v20081027-2115]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.core.filesystem.win32.x86' range='[1.1.0.v20080604-1400,1.1.0.v20080604-1400]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.equinox.p2.touchpoint.natives' range='[1.0.0.v20080505-1850,1.0.0.v20080505-1850]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.mortbay.jetty' range='[5.1.14.v200806031611,5.1.14.v200806031611]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='org.rodinp.platform.product.launcher.gtk.linux.x86.rodin' range='[1.1.0.r7661,1.1.0.r7661]'>
          <filter>
            (&amp; (osgi.os=linux)(osgi.ws=gtk)(osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingorg.eclipse.equinox.simpleconfigurator' range='[1.0.0.v20080604,1.0.0.v20080604]'/>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.jface.databinding' range='[1.2.1.M20080827-0800a,1.2.1.M20080827-0800a]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingwin32.win32.x86org.eclipse.ui.intro' range='[3.2.201.v20080702_34x,3.2.201.v20080702_34x]'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.presentations.r21' range='[3.2.100.I20080512-2000,3.2.100.I20080512-2000]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.sat4j.pb' range='[2.0.3.v20081021,2.0.3.v20081021]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolingcarbon.macosx.ppcorg.eclipse.ui.console' range='[3.3.1.v20090128_r342,3.3.1.v20090128_r342]'>
          <filter>
            (&amp; (osgi.ws=carbon) (osgi.os=macosx) (osgi.arch=ppc))
          </filter>
        </required>
        <required namespace='org.eclipse.equinox.p2.iu' name='toolinggtk.linux.x86org.eclipse.compare' range='[3.4.1.r34x_20090121,3.4.1.r34x_20090121]'>
          <filter>
            (&amp; (osgi.ws=gtk) (osgi.os=linux) (osgi.arch=x86))
          </filter>
        </required>
        <required namespace='toolingorg.rodinp.platform.product' name='org.rodinp.platform.product.launcher' range='[1.1.0.r7661,1.1.0.r7661]' multiple='true'/>
        <required namespace='toolingorg.rodinp.platform.product' name='org.rodinp.platform.product.ini' range='[1.1.0.r7661,1.1.0.r7661]'/>
        <required namespace='toolingorg.rodinp.platform.product' name='org.rodinp.platform.product.config' range='[1.1.0.r7661,1.1.0.r7661]'/>
        <required namespace='org.eclipse.equinox.p2.iu' name='tooling.osgi.bundle.default' range='0.0.0'/>
        <required namespace='org.eclipse.equinox.p2.iu' name='tooling.source.default' range='0.0.0'/>
        <required namespace='org.eclipse.equinox.p2.iu' name='tooling.org.eclipse.update.feature.default' range='0.0.0' optional='true'>
          <filter>
            (org.eclipse.update.install.features=true)
          </filter>
        </required>
      </requires>
      <touchpoint id='org.eclipse.equinox.p2.osgi' version='1.0.0'/>
      <touchpointData size='1'>
        <instructions size='2'>
          <instruction key='configure'>

          </instruction>
          <instruction key='unconfigure'>

          </instruction>
        </instructions>
      </touchpointData>
    </unit>
    <unit id='org.rodinp.platform.product.launcher.win32.win32.x86' version='1.1.0.r7661'>
      <provides size='2'>
        <provided namespace='org.eclipse.equinox.p2.iu' name='org.rodinp.platform.product.launcher.win32.win32.x86' version='1.1.0.r7661'/>
        <provided namespace='toolingorg.rodinp.platform.product' name='org.rodinp.platform.product.launcher' version='1.1.0.r7661'/>
      </provides>
      <requires size='1'>
        <required namespace='org.eclipse.equinox.p2.iu' name='org.eclipse.equinox.launcher.win32.win32.x86' range='0.0.0'>
          <filter>
            (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
          </filter>
        </required>
      </requires>
      <filter>
        (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
      </filter>
      <artifacts size='1'>
        <artifact classifier='binary' id='org.rodinp.platform.product.launcher.win32.win32.x86' version='1.1.0.r7661'/>
      </artifacts>
      <touchpoint id='org.eclipse.equinox.p2.native' version='1.0.0'/>
    </unit>
    <unit id='toolingorg.rodinp.platform.product.launcher.win32.win32.x86' version='1.1.0.r7661' singleton='false'>
      <hostRequirements size='1'>
        <required namespace='org.eclipse.equinox.p2.iu' name='org.rodinp.platform.product.launcher.win32.win32.x86' range='[1.1.0.r7661,1.1.0.r7661]'/>
      </hostRequirements>
      <properties size='1'>
        <property name='org.eclipse.equinox.p2.type.fragment' value='true'/>
      </properties>
      <provides size='1'>
        <provided namespace='org.eclipse.equinox.p2.iu' name='toolingorg.rodinp.platform.product.launcher.win32.win32.x86' version='1.1.0.r7661'/>
      </provides>
      <requires size='1'>
        <required namespace='org.eclipse.equinox.p2.iu' name='org.rodinp.platform.product.launcher.win32.win32.x86' range='[1.1.0.r7661,1.1.0.r7661]'/>
      </requires>
      <filter>
        (&amp; (osgi.ws=win32) (osgi.os=win32) (osgi.arch=x86))
      </filter>
      <touchpoint id='org.eclipse.equinox.p2.native' version='1.0.0'/>
      <touchpointData size='1'>
        <instructions size='2'>
          <instruction key='uninstall'>
            cleanupzip(source:@artifact, target:${installFolder});
          </instruction>
          <instruction key='install'>
            unzip(source:@artifact, target:${installFolder});
          </instruction>
        </instructions>
      </touchpointData>
    </unit>
    <unit id='a.jre' version='1.6.0' singleton='false'>
      <provides size='117'>
        <provided namespace='org.eclipse.equinox.p2.iu' name='a.jre' version='1.6.0'/>
        <provided namespace='java.package' name='javax.accessibility' version='0.0.0'/>
        <provided namespace='java.package' name='javax.activity' version='0.0.0'/>
        <provided namespace='java.package' name='javax.crypto' version='0.0.0'/>
        <provided namespace='java.package' name='javax.crypto.interfaces' version='0.0.0'/>
        <provided namespace='java.package' name='javax.crypto.spec' version='0.0.0'/>
        <provided namespace='java.package' name='javax.imageio' version='0.0.0'/>
        <provided namespace='java.package' name='javax.imageio.event' version='0.0.0'/>
        <provided namespace='java.package' name='javax.imageio.metadata' version='0.0.0'/>
        <provided namespace='java.package' name='javax.imageio.plugins.bmp' version='0.0.0'/>
        <provided namespace='java.package' name='javax.imageio.plugins.jpeg' version='0.0.0'/>
        <provided namespace='java.package' name='javax.imageio.spi' version='0.0.0'/>
        <provided namespace='java.package' name='javax.imageio.stream' version='0.0.0'/>
        <provided namespace='java.package' name='javax.management' version='0.0.0'/>
        <provided namespace='java.package' name='javax.management.loading' version='0.0.0'/>
        <provided namespace='java.package' name='javax.management.modelmbean' version='0.0.0'/>
        <provided namespace='java.package' name='javax.management.monitor' version='0.0.0'/>
        <provided namespace='java.package' name='javax.management.openmbean' version='0.0.0'/>
        <provided namespace='java.package' name='javax.management.relation' version='0.0.0'/>
        <provided namespace='java.package' name='javax.management.remote' version='0.0.0'/>
        <provided namespace='java.package' name='javax.management.remote.rmi' version='0.0.0'/>
        <provided namespace='java.package' name='javax.management.timer' version='0.0.0'/>
        <provided namespace='java.package' name='javax.naming' version='0.0.0'/>
        <provided namespace='java.package' name='javax.naming.directory' version='0.0.0'/>
        <provided namespace='java.package' name='javax.naming.event' version='0.0.0'/>
        <provided namespace='java.package' name='javax.naming.ldap' version='0.0.0'/>
        <provided namespace='java.package' name='javax.naming.spi' version='0.0.0'/>
        <provided namespace='java.package' name='javax.net' version='0.0.0'/>
        <provided namespace='java.package' name='javax.net.ssl' version='0.0.0'/>
        <provided namespace='java.package' name='javax.print' version='0.0.0'/>
        <provided namespace='java.package' name='javax.print.attribute' version='0.0.0'/>
        <provided namespace='java.package' name='javax.print.attribute.standard' version='0.0.0'/>
        <provided namespace='java.package' name='javax.print.event' version='0.0.0'/>
        <provided namespace='java.package' name='javax.rmi' version='0.0.0'/>
        <provided namespace='java.package' name='javax.rmi.CORBA' version='0.0.0'/>
        <provided namespace='java.package' name='javax.rmi.ssl' version='0.0.0'/>
        <provided namespace='java.package' name='javax.security.auth' version='0.0.0'/>
        <provided namespace='java.package' name='javax.security.auth.callback' version='0.0.0'/>
        <provided namespace='java.package' name='javax.security.auth.kerberos' version='0.0.0'/>
        <provided namespace='java.package' name='javax.security.auth.login' version='0.0.0'/>
        <provided namespace='java.package' name='javax.security.auth.spi' version='0.0.0'/>
        <provided namespace='java.package' name='javax.security.auth.x500' version='0.0.0'/>
        <provided namespace='java.package' name='javax.security.cert' version='0.0.0'/>
        <provided namespace='java.package' name='javax.security.sasl' version='0.0.0'/>
        <provided namespace='java.package' name='javax.sound.midi' version='0.0.0'/>
        <provided namespace='java.package' name='javax.sound.midi.spi' version='0.0.0'/>
        <provided namespace='java.package' name='javax.sound.sampled' version='0.0.0'/>
        <provided namespace='java.package' name='javax.sound.sampled.spi' version='0.0.0'/>
        <provided namespace='java.package' name='javax.sql' version='0.0.0'/>
        <provided namespace='java.package' name='javax.sql.rowset' version='0.0.0'/>
        <provided namespace='java.package' name='javax.sql.rowset.serial' version='0.0.0'/>
        <provided namespace='java.package' name='javax.sql.rowset.spi' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.border' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.colorchooser' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.event' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.filechooser' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.plaf' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.plaf.basic' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.plaf.metal' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.plaf.multi' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.plaf.synth' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.table' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.text' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.text.html' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.text.html.parser' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.text.rtf' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.tree' version='0.0.0'/>
        <provided namespace='java.package' name='javax.swing.undo' version='0.0.0'/>
        <provided namespace='java.package' name='javax.transaction' version='0.0.0'/>
        <provided namespace='java.package' name='javax.transaction.xa' version='0.0.0'/>
        <provided namespace='java.package' name='javax.xml' version='0.0.0'/>
        <provided namespace='java.package' name='javax.xml.datatype' version='0.0.0'/>
        <provided namespace='java.package' name='javax.xml.namespace' version='0.0.0'/>
        <provided namespace='java.package' name='javax.xml.parsers' version='0.0.0'/>
        <provided namespace='java.package' name='javax.xml.transform' version='0.0.0'/>
        <provided namespace='java.package' name='javax.xml.transform.dom' version='0.0.0'/>
        <provided namespace='java.package' name='javax.xml.transform.sax' version='0.0.0'/>
        <provided namespace='java.package' name='javax.xml.transform.stream' version='0.0.0'/>
        <provided namespace='java.package' name='javax.xml.validation' version='0.0.0'/>
        <provided namespace='java.package' name='javax.xml.xpath' version='0.0.0'/>
        <provided namespace='java.package' name='org.ietf.jgss' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.CORBA' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.CORBA_2_3' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.CORBA_2_3.portable' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.CORBA.DynAnyPackage' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.CORBA.ORBPackage' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.CORBA.portable' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.CORBA.TypeCodePackage' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.CosNaming' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.CosNaming.NamingContextExtPackage' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.CosNaming.NamingContextPackage' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.Dynamic' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.DynamicAny' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.DynamicAny.DynAnyFactoryPackage' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.DynamicAny.DynAnyPackage' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.IOP' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.IOP.CodecFactoryPackage' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.IOP.CodecPackage' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.Messaging' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.PortableInterceptor' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.PortableInterceptor.ORBInitInfoPackage' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.PortableServer' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.PortableServer.CurrentPackage' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.PortableServer.POAManagerPackage' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.PortableServer.POAPackage' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.PortableServer.portable' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.PortableServer.ServantLocatorPackage' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.SendingContext' version='0.0.0'/>
        <provided namespace='java.package' name='org.omg.stub.java.rmi' version='0.0.0'/>
        <provided namespace='java.package' name='org.w3c.dom' version='0.0.0'/>
        <provided namespace='java.package' name='org.w3c.dom.bootstrap' version='0.0.0'/>
        <provided namespace='java.package' name='org.w3c.dom.events' version='0.0.0'/>
        <provided namespace='java.package' name='org.w3c.dom.ls' version='0.0.0'/>
        <provided namespace='java.package' name='org.xml.sax' version='0.0.0'/>
        <provided namespace='java.package' name='org.xml.sax.ext' version='0.0.0'/>
        <provided namespace='java.package' name='org.xml.sax.helpers' version='0.0.0'/>
      </provides>
      <touchpoint id='org.eclipse.equinox.p2.native' version='1.0.0'/>
    </unit>
  </units>
  <iusProperties size='4'>
    <iuProperties id='org.rodinp.platform.product' version='1.1.0.r7661'>
      <properties size='4'>
        <property name='org.eclipse.equinox.p2.internal.inclusion.rules' value='STRICT'/>
        <property name='org.eclipse.equinox.p2.type.root' value='true'/>
        <property name='org.eclipse.equinox.p2.type.lock' value='3'/>
        <property name='org.eclipse.equinox.p2.base' value='true'/>
      </properties>
    </iuProperties>
    <iuProperties id='org.rodinp.platform.product.launcher.win32.win32.x86' version='1.1.0.r7661'>
      <properties size='3'>
        <property name='unzipped|@artifact|/home/lvoisin/Rodin/1.1/work/result/tmp/rodin' value='/home/lvoisin/Rodin/1.1/work/result/tmp/rodin/rodin.ini|/home/lvoisin/Rodin/1.1/work/result/tmp/rodin/configuration/org.eclipse.equinox.source/source.info|/home/lvoisin/Rodin/1.1/work/result/tmp/rodin/configuration/config.ini|/home/lvoisin/Rodin/1.1/work/result/tmp/rodin/configuration/org.eclipse.equinox.simpleconfigurator/bundles.info|/home/lvoisin/Rodin/1.1/work/result/tmp/rodin/.eclipseproduct|/home/lvoisin/Rodin/1.1/work/result/tmp/rodin/rodin.exe|'/>
        <property name='org.eclipse.equinox.p2.type.lock' value='3'/>
        <property name='org.eclipse.equinox.p2.base' value='true'/>
      </properties>
    </iuProperties>
    <iuProperties id='toolingorg.rodinp.platform.product.launcher.win32.win32.x86' version='1.1.0.r7661'>
      <properties size='2'>
        <property name='org.eclipse.equinox.p2.type.lock' value='3'/>
        <property name='org.eclipse.equinox.p2.base' value='true'/>
      </properties>
    </iuProperties>
    <iuProperties id='a.jre' version='1.6.0'>
      <properties size='2'>
        <property name='org.eclipse.equinox.p2.type.lock' value='3'/>
        <property name='org.eclipse.equinox.p2.base' value='true'/>
      </properties>
    </iuProperties>
  </iusProperties>
</profile>
