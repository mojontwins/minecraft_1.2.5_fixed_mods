#Modloader for Minecraft 1.2.5

Originally created by Risugami.

This mod fails for modern / portable Minecraft 1.2.5 installation with a `java.lang.RuntimeException: java.lang.IllegalArgumentException: URI is not hierarchical` exception. 

The fix is applied to `ModLoader.java` and is based on [coffeenotfound's fix for b1.7.3](https://github.com/coffeenotfound/ModloaderFix-b1.7.3).

You can use the original mod and replace `ModLoader.class` or use the zip provided in this folder. Just put those files in you `minecraft.jar` / `1.2.5.jar` and delete the `META-INF` as usual.
