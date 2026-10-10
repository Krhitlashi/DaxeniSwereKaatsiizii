# Hantami Folk 🏘️

Living mannequin folk with random skins who roam the kaaliqlaakaarace world like players.

## Haŭtoj 🎨

Every Hantami skin comes from a username in `plugins/Hantami/nomoj.txt`; add one username per line to choose the available skins. The plugin does not discover or validate names; this file is the complete skin pool.

The default natural population target and limit are one Hantami. Command-created Hantami can exceed that limit. Natural replenishment adds at most one every five minutes. Hantami UUIDs are persisted so unloading their chunks does not make the plugin replace them.

## Konduto 🧭

Each Hantami wanders on foot, faces where it walks, and slowly builds simple wooden houses block by block while staying at the site. Houses use the wood of the local biome with stripped log pillars at the corners plus plank walls topped by an outward facing stair rim and a flush plank roof in random sizes, and each finished house holds a chest with various loot plus twin torches flanking the doorway. Campfires never duplicate near an existing one, and log seats sit on real ground.

When Hantami drift near each other they congregate. A group forms a village with a lit campfire at its center ringed by log seats.

## Kolero ⚔️

Hantami are calm until provoked. Attack one and it fights back bare handed with a spooky aggro display. Leave one Hantami alone with a player and no other Hantami nearby for more than 2 qe and it also turns hostile. A lone player with no other players far around gets stalked and attacked after a short ambush wait. At night one in four Hantami falls into nightmare rage with high jumps, spinning head, ash, heartbeat, and a darkness aura, and dawn always ends it. In aggro mode the mob spins its head, jitters, glows, and shows a vertical split of dark particles across its face that opens and closes. A true vertical model split needs a resource pack, so this particle jaw plus spin is the pack free haunting.

Killing a Hantami drops a totem of undying.

## Komandoj 💬

All commands need hantami.admin which defaults to op.

```text
/hantami fezi
/hantami veseno <nombro>
/hantami soto
/hantami h2l
/hantami s2tosax
```

## Agordo 🗂️

Edit src/main/resources/config.yml then run /hantami s2tosax or restart.

## Konstruo 🛠️

Run konstruu.ps1 from this folder with PowerShell to compile with javac against the server libraries and to create build/Hantami.jar. Then copy build/Hantami.jar into plugins and restart.
