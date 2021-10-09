# Not Enough Items

This mod fails for modern / portable Minecraft 1.2.5 installation with a `java.lang.RuntimeException: java.lang.IllegalArgumentException: URI is not hierarchical` exception. 

The fix is applied to `codechicken/nei/TMIUninstaller.java` and is based on [coffeenotfound's fix for b1.7.3](https://github.com/coffeenotfound/ModloaderFix-b1.7.3).

This mod needs **Codechicken Core** which is also bugged, so use the fix in this repo. To use, add the files in both packages to `minecraft.jar` / `1.2.5.jar` and delete the `META-INF` as usual.
