
-- randomized_state_machine.lua

local M = {}

-- Play random shooting animation from a list defined in params
function M.playRandomShootAnim(context)
    local param = context:getParams()
    local shoot_anims = param["random_shoot_anims"] or {}

    -- Expect random_shoot_anims as a list of animation names, e.g. ["shoot_left", "shoot_right", "shoot_down"]
    if #shoot_anims == 0 then
        -- fallback default
        context:runAnimation("shoot", context:getTrack("STATIC_TRACK_LINE", "MAIN_TRACK"), false, PLAY_ONCE_STOP, 0.05)
        return
    end

    local choice = shoot_anims[math.random(#shoot_anims)]
    context:runAnimation(choice, context:getTrack("STATIC_TRACK_LINE", "MAIN_TRACK"), false, PLAY_ONCE_STOP, 0.05)
end

return M
