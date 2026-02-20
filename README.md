# Hex Shadowing

![Screenshot of linking two stacks of amethyst shards. A scroll displaying the spell is in the background.](example.png)

A Hex Casting addon that enables item shadowing.

Adds a single Great Spell to shadow link two dropped items. Two linked stacks behave like they are one -
items added to one sync to the other, and items removed also vanish from the other stack. (In fact,
they *are* the same ItemStack internally.) Managing linked items without disconnecting them requires
some care, but also enables a number of unique applications, such as remote item restocking,
item storage, wireless hoppers, wireless redstone, etc.

This brings back the same item shadowing exploit that Mojang patched in 1.19, without the need to
perform update suppression. Behavior regarding what actions are safe (preserve the link) and what is
not is largely the same. This addon modifies a block entity's behavior to make it possible to
get linked item entities back into an inventory safely. (The original 1.17 exploit did not need this
as initial linking was done in-inventory.)

1.17/1.18 item shadowing behavior is documented in two excellent videos
by [PR0CESS](https://youtube.com/watch?v=i8_FPyn20ns)
and [Fallen_Breath](https://youtube.com/watch?v=mTeYwq7HaEA).

## Balancing Note (Server Owners Please Read)

1.17 item shadowing was inherently a general item dupe exploit that came with additional, more
interesting applications. This mod seeks to re-enable the latter applications without significantly
impacting balance. To link items, two full stacks of the same item are required - this should be the
maximum number of items that a player can get back after unlinking. Thus, there is no known general
item duplication glitch with just the vanilla game, Hex Casting, and this addon. (Smaller tricks, like
mending two broken tools with the xp cost of one, are possible and will not be patched.) However,
it may be possible to duplicate items by using this addon in combination with some other mod.

A configurable blacklist of linkable items is planned for a future release of this addon. Blacklisting
by item type, tag, damageability, enchantments, and other properties is planned. 
