import codechicken.core.CoreUtils;
import codechicken.core.ICustomPacketHandler;
import codechicken.core.PacketCustom;
import codechicken.nei.LayoutManager;
import codechicken.nei.NEICompatibility;
import codechicken.nei.NEIConfig;
import codechicken.nei.NEIController;
import codechicken.nei.NEIPacketHandler;
import codechicken.nei.NEIUtils;
import codechicken.nei.TMIUninstaller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;

@SrcPackager(getName = "NotEnoughItems", getClasses = {"net.minecraft.src", "codechicken.nei"}, getMappedDirectories = {"NEI.Client;Client", "NEI.Common;Common", "NEI.Server;Server"})
@Packager(getName = "NotEnoughItems$-", getVersion = "1.3", getClasses = {"net.minecraft.src", "codechicken.nei"}, getBaseDirectories = {"NEI.Client", "NEI.Common"})
public class mod_NotEnoughItems
	extends BaseMod
{
	private xd lastworld;
	
	public void load() {
		instance = this;

		
		try {
			TMIUninstaller.deleteTMIUninstaller();
			
			if (TMIUninstaller.TMIInstalled())
			{
				TMIUninstaller.runTMIUninstaller();
				
				NEIUtils.getMinecraft().d();
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		
		ModLoader.setInGameHook(this, true, true);
		ModLoader.setInGUIHook(this, true, true);
		ModLoader.addLocalization("entity.SnowMan.name", "Snow Golem");
		PacketCustom.assignHandler("NEI", 0, 255, (ICustomPacketHandler)new NEIPacketHandler());
	}

	
	public static void addSMPMagneticItem(int i, xd world) {
		je cworld = (je)world;
		nn e = cworld.a(i);
		if (e == null || !(e instanceof fq)) {
			return;
		}
		
		instance.SMPmagneticItems.add((fq)e);
	}

	
	public static void reset(xd world) {
		instance.lastworld = world;
		NEIConfig.loadWorld();
		NEIConfig.setHasSMPCounterPart(false);
		instance.SMPmagneticItems.clear();
	}

	
	public boolean onTickInGame(float f, Minecraft mc) {
		if (mc.f != this.lastworld)
		{
			reset(mc.f);
		}
		
		NEIController.updateUnlimitedItems(mc.h.ap);
		NEIController.processCreativeCycling(mc.h.ap);
		
		updateMagnetMode(mc.f, mc.h);
		removeDrops(mc.f);
		processDisabledProperties();
		
		if (mc.s instanceof gb && LayoutManager.getInputFocused() != null)
		{
			NEICompatibility.disableMillenaireKeys();
		}

		
		try {
			if (((Integer)ModLoader.getPrivateValue(l.class, mc.g, 25)).intValue() > 0) {
				ahu.a.a(mc.f, mc.p, mc.q, mc.i, mc.A, f);
			}
		} catch (Exception e) {
			
			NEIUtils.reportException(e);
		} 
		
		return true;
	}

	
	private void processDisabledProperties() {
		if (NEIConfig.isMultiplayer())
			return; 
		NEIUtils.advanceDisabledTimes();
		if (NEIUtils.isRaining() && NEIConfig.isPropertyDisabled("rain")) {
			NEIUtils.toggleRaining();
		}
	}

	
	public boolean onTickInGUI(float f, Minecraft minecraft, vp guiscreen) {
		if (guiscreen instanceof xt) {
			
			if (this.firstTick) {
				
				this.firstTick = false;
				initMainMenu();
			} 
			
			if (this.lastworld != null)
			{
				this.lastworld = null;
			}
		} 
		return true;
	}

	
	private void initMainMenu() {
		if (NEIConfig.getBooleanSetting("ID dump.dump on load")) {
			NEIUtils.dumpIDs();
		}
	}

	
	private void removeDrops(xd world) {
		if (CoreUtils.isClient() || 
			NEIConfig.getBooleanSetting("options.itemdrops"))
			return; 
		List items = world.b;
		for (nn e : items) {
			
			if (e instanceof fq)
			{
				e.A();
			}
		} 
	}

	
	private void updateMagnetMode(xd world, vq player) {
		List items;
		if (!NEIConfig.getMagnetMode())
			return; 
		float distancexz = 16.0F;
		float distancey = 8.0F;
		double maxspeedxz = 0.5D;
		double maxspeedy = 0.5D;
		double speedxz = 0.05D;
		double speedy = 0.07D;

		
		if (world.F) {
			
			items = this.SMPmagneticItems;
		}
		else {
			
			items = world.a(fq.class, player.y.b(distancexz, distancey, distancexz));
		} 
		for (Iterator<fq> iterator = items.iterator(); iterator.hasNext(); ) {
			
			fq item = iterator.next();
			
			if (item.c > 0)
				continue;  if (item.G && world.F) iterator.remove();
			
			if (!NEIUtils.canItemFitInInventory((yw)player, item.a))
				continue; 
			double dx = player.o - item.o;
			double dy = player.p + player.I() - item.p;
			double dz = player.q - item.q;
			double absxz = Math.sqrt(dx * dx + dz * dz);
			double absy = Math.abs(dy);
			if (absxz > distancexz) {
				continue;
			}

			
			if (absxz > 1.0D) {
				
				dx /= absxz;
				dz /= absxz;
			} 
			
			if (absy > 1.0D)
			{
				dy /= absy;
			}
			
			double vx = item.r + speedxz * dx;
			double vy = item.s + speedy * dy;
			double vz = item.t + speedxz * dz;
			
			double absvxz = Math.sqrt(vx * vx + vz * vz);
			double absvy = Math.abs(vy);
			
			double rationspeedxz = absvxz / maxspeedxz;
			if (rationspeedxz > 1.0D) {
				
				vx /= rationspeedxz;
				vz /= rationspeedxz;
			} 
			
			double rationspeedy = absvy / maxspeedy;
			if (rationspeedy > 1.0D)
			{
				vy /= rationspeedy;
			}
			
			if (absvxz < 0.2D && absxz < 0.2D && world.F)
			{
				item.A();
			}
			
			item.a(vx, vy, vz);
		} 
	}

	
	public String getVersion() {
		return ((Packager)getClass().<Packager>getAnnotation(Packager.class)).getVersion();
	}

	
	public static ne foodStats(yw player) {
		return player.as;
	}


	
	public static ArrayList getCreativeItemList() {
		return (ArrayList)(new os((yw)(ModLoader.getMinecraftInstance()).h)).a;
	}

	
	private boolean firstTick = true;
	
	private static mod_NotEnoughItems instance;
	
	private ArrayList SMPmagneticItems = new ArrayList();
}


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\mod_NotEnoughItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */