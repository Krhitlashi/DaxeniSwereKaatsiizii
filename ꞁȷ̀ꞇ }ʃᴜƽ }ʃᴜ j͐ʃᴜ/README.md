# Nala portal travel 🚪

Nala lets players travel between custom dimensions and overworld using living water portals or the /nala command.

## Casokfamii block 🧱

Casokfamii is the item named ſɟᴜ j͑ʃɜ ſɭʞᴜ ŋᷠɹ. It looks like a water bucket. Pour it to create still portal water in any layout. A doorway a pool a path or a full wall. Poured blocks turn warm ocean cyan through biome tint with no resource pack and glow with white sparkles spawned by the plugin. Nearby grass may also tint warm from the same biome cell.

- Get buckets with /nala au1e for one or /nala au1e 3 for one plus 3 more or /nala au1e ludanto 2 for that player. Buckets do not stack so each fills one slot and overflow drops at your feet. Pouring never consumes the bucket.
- Pour onto air to place portal water. Only water poured from the named bucket counts and it is tracked per world in portals.yml with its original biome saved.
- Step inside the water to open the travel menu. Proximity alone never triggers.
- Portal water never flows never freezes and cannot be scooped back into a bucket.
- Remove portal water with a sponge. Sponge absorption unregisters the blocks and restores the saved biome.
- Explosions unregister destroyed blocks with no drops.

## How it works ⚙️

Each poured casokfamii block is tracked in portals.yml per world with its coordinates. Stepping inside living portal water at feet or head level opens the travel menu once per entry. Standing inside never retriggers. Step out and back in to open it again. Every 8 ticks each tracked block gets a white sparkle.

The menu lists overworld plus all custom dimensions except the current one. Picking a world teleports the player to its saved portal. When that world has no portal the player lands at its spawn instead with a notice and nothing is built there. The /nala command opens the same menu from anywhere with no portal needed.

## Commands 💬

Every command needs nala.admin which defaults to op. Touching portals needs only nala.uzi which defaults to true. Commands work from console except the ones that need your position.

Travel menu for yourself.

```text
/nala
```

Travel menu for another online player.

```text
/nala <player>
```

Send another online player straight to a world with its portal arrival.

```text
/nala <player> <dimension>
```

Give buckets. One by default and a number adds more on top.

```text
/nala au1e
/nala au1e <number>
/nala au1e <player> <number>
```

List the worlds you can travel to from where you stand.

```text
/nala oku3a
```

Reload config and ensure worlds. Works from console.

```text
/nala s2tosax
```

Import an external world folder. Drop the folder into plugins/Nala/import first. The name becomes lowercase automatically. Medio is memdetektita from the folder layout so typing it is optional and only overrides.

```text
/nala importi <download>
/nala importi <download> <mapname>
/nala importi <download> <mapname> <dimension>
```

A folder with only nether data becomes NETHER and only end data becomes THE_END and anything with an overworld becomes NORMAL. A full save with all three imports its overworld unless you name NETHER or THE_END explicitly.

Accepted layouts are new vanilla saves with dimensions, old saves with a region folder, and old nether or end folders with DIM-1 or DIM1. Only region entities poi and data are copied and never players or datapacks. Imported worlds load at once with no restart and stay in config for next starts.

## Travel flow 🧭

1. Player touches casokfamii water or runs /nala.
2. Menu shows available worlds without the current dimension.
3. Player clicks a world.
4. Plugin returns the player to their last spot in that world when one is remembered. Otherwise it finds the portal on the other side or falls back to that world spawn with a notice.
5. Player teleports there with a welcome message.
6. Leaving spots are remembered on every Nala trip and on quit in plugins/Nala/lokoj.yml.

## Config 🗂️

Edit src/main/resources/config.yml then run /nala s2tosax or restart.

- mondoj lists custom worlds to auto create with WorldCreator and minecraft namespace.
- Each mondo entry holds nomo plus optional medio semo generilo datumpako rimedpako.
- semo takes a number or text like vanilla. Numeric text parses to the same number and other text hashes. Empty means random.
- generilo empty is vanilla or one installed plugin name for that world only. Missing plugins fall back to vanilla with a warning.
- datumpako lists zip or folder names from plugins/Nala/datumpako. They copy to the level datapacks folder on ensure. Datapacks are level wide in vanilla so use one pack set per level. Reload or restart to enable new packs.
- rimedpako lists http links or zip names from plugins/Nala/rimedpako. Local zips serve over http on rimedpako-haveno and players fetch them on travel. Multiple packs stack with stable ids. Leaving a world removes its packs.
- rimedpako-gastiganto empty means auto LAN IP for local links. Set it to a public host when players connect from outside the LAN.
- rimedpako-haveno holds the file host port and defaults to 8192.
- montri-nether-end shows nether and end when true.
- malstreco is kept for compat and no longer gates triggers.
- maks-grando is kept for compat.

Remove a mondo entry and restart to stop auto loading it. Delete its folder under akitsalsiixu/dimensions/minecraft to replace it.

## Build 🛠️

Run konstruu.ps1 from this folder with PowerShell to compile with javac against the server libraries and to create build/Nala.jar. Then copy build/Nala.jar into plugins and restart.

## Notes 📄

- Built for Paper 26.2 and Java 25.
- Only minecraft namespace worlds are supported on 26.2.
- Portal data lives in plugins/Nala/portals.yml.
- Old entries from portal block days are ignored since only living water counts now.
