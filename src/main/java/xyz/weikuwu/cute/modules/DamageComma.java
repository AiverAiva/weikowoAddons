package xyz.weikuwu.cute.modules;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import xyz.weikuwu.cute.weikowoAddons;

import java.text.NumberFormat;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DamageComma {
    private static final WeakHashMap<EntityLivingBase, ChatComponentText> replacementMap = new WeakHashMap<>();

    private static final EnumChatFormatting[] coloursHypixel = {
            EnumChatFormatting.WHITE,
            EnumChatFormatting.YELLOW,
            EnumChatFormatting.GOLD,
            EnumChatFormatting.RED,
            EnumChatFormatting.RED,
            EnumChatFormatting.WHITE
    };

    private static final char STAR = '\u2727';
    private static final Pattern PATTERN_CRIT = Pattern.compile(
            "\u00a7f" + STAR + "((?:\u00a7.\\d)+)\u00a7." + STAR + "(.*)");
    private static final Pattern PATTERN_NO_CRIT = Pattern.compile("\u00a77(\\d+)(.*)");

    public static IChatComponent replaceName(EntityLivingBase entity) {
        if (!entity.hasCustomName()) return entity.getDisplayName();

        IChatComponent name = entity.getDisplayName();
        if (!weikowoAddons.INSTANCE.config.damagecomma) return name;

        if (replacementMap.containsKey(entity)) {
            ChatComponentText component = replacementMap.get(entity);
            if (component == null) return name;
            return component;
        }

        String formatted = name.getFormattedText();

        boolean crit = false;
        String numbers;
        String prefix;
        String suffix;

        Matcher matcherCrit = PATTERN_CRIT.matcher(formatted);
        if (matcherCrit.matches()) {
            crit = true;
            numbers = cleanColour(matcherCrit.group(1));
            prefix = "\u00a7f" + STAR;
            suffix = "\u00a7f" + STAR + matcherCrit.group(2);
        } else {
            Matcher matcherNoCrit = PATTERN_NO_CRIT.matcher(formatted);
            if (matcherNoCrit.matches()) {
                numbers = matcherNoCrit.group(1);
                prefix = "\u00A77";
                suffix = "\u00A7r" + matcherNoCrit.group(2);
            } else {
                replacementMap.put(entity, null);
                return name;
            }
        }

        StringBuilder newFormatted = new StringBuilder();

        try {
            int number = Integer.parseInt(numbers);

            if (number > 999) {
                newFormatted.append(shortNumberFormat(number, 0));
            } else {
                newFormatted.append(NumberFormat.getIntegerInstance().format(number));
            }
        } catch (NumberFormatException e) {
            replacementMap.put(entity, null);
            return name;
        }

        if (crit) {
            StringBuilder newFormattedCrit = new StringBuilder();

            int colourIndex = 0;
            for (char c : newFormatted.toString().toCharArray()) {
                if (c == ',') {
                    newFormattedCrit.append(EnumChatFormatting.GRAY);
                } else {
                    newFormattedCrit.append(coloursHypixel[colourIndex++ % coloursHypixel.length]);
                }
                newFormattedCrit.append(c);
            }

            newFormatted = newFormattedCrit;
        }

        ChatComponentText finalComponent = new ChatComponentText(prefix + newFormatted + suffix);

        replacementMap.put(entity, finalComponent);
        return finalComponent;
    }

    public static String cleanColour(String in) {
        return in.replaceAll("(?i)\\u00A7.", "");
    }

    private static final char[] c = new char[]{'k', 'm', 'b', 't'};
    public static String shortNumberFormat(double n, int iteration) {
        double d = ((long) n / 100) / 10.0;
        boolean isRound = (d * 10) % 10 == 0;
        return (d < 1000 ?
                ((d > 99.9 || isRound || (!isRound && d > 9.99) ?
                        (int) d * 10 / 10 : d + ""
                ) + "" + c[iteration])
                : shortNumberFormat(d, iteration + 1));
    }
}
