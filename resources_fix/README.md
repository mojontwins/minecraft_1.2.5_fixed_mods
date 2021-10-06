# Resources mod

By *na_th_an*.

The original Minecraft 1.2.5 loads resources from `http://s3.amazonaws.com/MinecraftResources/` which produces 403 errors on downloading, so you had to play without sounds. This patch fixes this by changing the default base URL to [https://betacraft.pl](Betacraft's) `https://betacraft.pl/MinecraftResources/`, but allows you to easily change it by defining an environment variable called `RESOURCES_URL`. 

To use this fix just add `ck.class` to your `minecraft.jar` / `1.2.5.jar` and delete the `META-INF` as usual.
